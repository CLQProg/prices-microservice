package es.technical.test.microservices.prices.it.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.hibernate.query.sql.internal.NativeQueryImpl;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Map;

/**
 * Generic repository utility, used to extract values from the database and construct assertions in tests.
 */
@Component
public class GenericRepository {

  @Autowired
  private EntityManager entityManager;

  /**
   * Find all the rows in the given table sorting them by the given field.
   *
   * @param table table to extract rows from.
   * @param sortField field to sort by.
   * @return all the rows in the given table sorting them by the given field.
   */
  @SuppressWarnings(value = "unused")
  @Transactional
  public List<Map<String, Object>> findAll(final String table, final String sortField) {
    final NativeQueryImpl<?> query = getNativeQueryImpl(entityManager.createNativeQuery("SELECT * FROM \"" + table
        + "\" ORDER BY \"" + sortField + "\""));
    return (List<Map<String, Object>>) query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE).getResultList();
  }

  /**
   * Find all the rows in the given table, using the given filter, sorting them by the given field.
   *
   * @param table table to extract rows from.
   * @param fieldName field to filter by.
   * @param fieldValue the value of the field to filter by.
   * @param sortField field to sort by.
   * @return all the rows in the given table that meet the given filter, sorting them by the given field.
   */
  @SuppressWarnings(value = "unused")
  @Transactional
  public List<Map<String, Object>> findAll(final String table, final String fieldName, final String fieldValue, final String sortField) {
    final String queryString = String.format("SELECT * FROM \"%s\" WHERE \"%s\" = ? ORDER BY \"%s\"", table, fieldName, sortField);
    final NativeQueryImpl<?> query = getNativeQueryImpl(entityManager.createNativeQuery(queryString));
    return (List<Map<String, Object>>) query
        .setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE)
        .setParameter(1, fieldValue)
        .getResultList();
  }

  private NativeQueryImpl<?> getNativeQueryImpl(Object proxy) {
    if (proxy instanceof NativeQueryImpl) {
      return (NativeQueryImpl<?>) proxy;
    }
    try {
      return NativeQueryImpl.class.cast(ReflectionTestUtils.getField(Proxy.getInvocationHandler(proxy), "target"));
    } catch (Throwable ex) {
      throw new RuntimeException(ex.getMessage(), ex);
    }
  }
}

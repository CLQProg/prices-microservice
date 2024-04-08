package es.technical.test.microservices.prices.infrastructure.repository.h2;


import es.technical.test.microservices.prices.infrastructure.repository.h2.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * {@link PriceEntity} H2 repository.
 */
@Repository
public interface SpringDataH2PriceEntityRepository extends JpaRepository<PriceEntity, Long>,
        JpaSpecificationExecutor<PriceEntity> {

    @Query("SELECT p FROM PriceEntity p " +
            "WHERE p.brandEntityId = :brandId " +
            "AND p.productEntityId = :productId " +
            "AND p.startDate < :date " +
            "AND p.endDate > :date " +
            "ORDER BY p.priority DESC " +
            "LIMIT 1")
    Optional<PriceEntity> findByBrandAndProductAndDateWithMaxPriority(@Param("brandId") Long brandId,
                                                                      @Param("productId") Long productId,
                                                                      @Param("date") LocalDateTime date);

}

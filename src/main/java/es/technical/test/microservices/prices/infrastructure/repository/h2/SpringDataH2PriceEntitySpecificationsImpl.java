package es.technical.test.microservices.prices.infrastructure.repository.h2;


import es.technical.test.microservices.prices.infrastructure.repository.h2.entity.PriceEntity;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

/**
 * {@link SpringDataH2PriceEntitySpecifications} implementation.
 */
@SuppressWarnings("unused")
public class SpringDataH2PriceEntitySpecificationsImpl implements SpringDataH2PriceEntitySpecifications {

    /**
     * Specifies the product id of the Price to consult.
     *
     * @param productId Product ID.
     * @return Specification.
     */
    public Specification<PriceEntity> hasProductWithId(Long productId) {
        return (price, query, builder) -> {
            if (productId == null) {
                return builder.conjunction();
            }
            return builder.equal(price.get("productEntityId"), productId);
        };
    }

    /**
     * Specifies the brand id of the Price to consult.
     *
     * @param brandId Brand ID.
     * @return Specification.
     */
    public Specification<PriceEntity> hasBrandWithId(Long brandId) {
        return (price, query, builder) -> {
            if (brandId == null) {
                return builder.conjunction();
            }
            return builder.equal(price.get("brandEntityId"), brandId);
        };
    }


    /**
     * Specify the expiration date of the Price to consult.
     *
     * @param date Date.
     * @return Specification.
     */
    public Specification<PriceEntity> hasStartDateLessThan(LocalDateTime date) {
        return (price, query, builder) -> {
            if (date == null) {
                return builder.conjunction();
            }
            return builder.lessThanOrEqualTo(price.get("startDate"), date);
        };
    }

    /**
     * Specify the start date of the Price to consult.
     *
     * @param date Date.
     * @return Specification.
     */
    public Specification<PriceEntity> hasEndDateGreaterThan(LocalDateTime date) {
        return (price, query, builder) -> {
            if (date == null) {
                return builder.conjunction();
            }
            return builder.or(
                    builder.greaterThan(price.get("endDate"), date),
                    builder.isNull(price.get("endDate"))
            );
        };
    }

}

package es.technical.test.microservices.prices.infrastructure.repository.h2;

import es.technical.test.microservices.prices.infrastructure.repository.h2.entity.PriceEntity;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

/**
 * Specifications to find prices.
 */
public interface SpringDataH2PriceEntitySpecifications {

    /**
     * Specifies the product id of the Price to consult.
     *
     * @param productId Product ID.
     * @return Specification.
     */
    Specification<PriceEntity> hasProductWithId(Long productId);

    /**
     * Specifies the brand id of the Price to consult.
     *
     * @param brandId Brand ID.
     * @return Specification.
     */
    Specification<PriceEntity> hasBrandWithId(Long brandId);

    /**
     * Specify the expiration date of the Price to consult.
     *
     * @param date Date.
     * @return Specification.
     */
    Specification<PriceEntity> hasStartDateLessThan(LocalDateTime date);

    /**
     * Specify the start date of the Price to consult.
     *
     * @param date Date.
     * @return Specification.
     */
    Specification<PriceEntity> hasEndDateGreaterThan(LocalDateTime date);

}

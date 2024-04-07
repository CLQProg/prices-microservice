package es.technical.test.microservices.prices.infrastructure.repository.h2.entity;


import es.technical.test.microservices.prices.domain.Price;
import es.technical.test.microservices.prices.domain.Product;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

/**
 * Price of a {@link Product}, which can have several {@link Price}s.
 */
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Entity
@Table(name = "prices")
public class PriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "price_list", nullable = false)
    Long id;

    /**
     * Initial date of application of the price.
     */
    @Setter
    @Column(name = "START_DATE", nullable = false, columnDefinition = "TIMESTAMP")
    LocalDateTime startDate;

    /**
     * Final date of application of the price.
     */
    @Setter
    @Column(name = "END_DATE", nullable = false, columnDefinition = "TIMESTAMP")
    LocalDateTime endDate;

    /**
     * Price application disambiguator. If two prices coincide in a range of dates, the one with the highest priority
     * (highest numerical value) is applied.
     */
    @Setter
    @Column(name = "PRIORITY")
    Long priority;

    /**
     * PVP or final sale price.
     */
    @Setter
    @Column(name = "PRICE", nullable = false)
    Double finalPrice;

    @Setter
    @Length(min = 3, max = 3)
    @Column(name = "CURR", nullable = false)
    String currency;

    @Column(name = "product_id", nullable = false)
    Long productEntityId;

    @Column(name = "brand_id", nullable = false)
    Long brandEntityId;

}

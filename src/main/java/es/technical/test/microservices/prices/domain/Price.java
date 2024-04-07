package es.technical.test.microservices.prices.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

/**
 * Price of a {@link Product}, which can have several {@link Price}s.
 */
@Getter
@Builder
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Price {

    Long id;

    /**
     * Initial date of application of the price.
     */
    LocalDateTime startDate;

    /**
     * Final date of application of the price.
     */
    LocalDateTime endDate;

    /**
     * Price application disambiguator. If two prices coincide in a range of dates, the one with the highest priority
     * (highest numerical value) is applied.
     */
    Long priority;

    /**
     * PVP or final sale price.
     */
    Double finalPrice;

    /**
     * ISO currency (v.gr.: EUR).
     */
    String currency;

}

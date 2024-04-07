package es.technical.test.microservices.prices.domain.repository;

import es.technical.test.microservices.prices.domain.Price;

import java.time.LocalDateTime;
import java.util.Set;

public interface PriceRepository {

    Set<Price> findProductPriceByBrandIdAndDate(Long brandId, Long productId, LocalDateTime date);

}

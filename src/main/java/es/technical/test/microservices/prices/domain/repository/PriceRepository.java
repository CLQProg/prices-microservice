package es.technical.test.microservices.prices.domain.repository;

import es.technical.test.microservices.prices.domain.Price;

import java.time.LocalDateTime;

public interface PriceRepository {

    Price findProductPriceByBrandIdAndDate(Long brandId, Long productId, LocalDateTime date);

}

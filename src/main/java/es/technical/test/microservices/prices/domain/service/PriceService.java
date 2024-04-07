package es.technical.test.microservices.prices.domain.service;

import es.technical.test.microservices.prices.domain.Price;

import java.time.LocalDateTime;


public interface PriceService {

    Price findProductPriceByBrandIdAndDate(Long brandId, Long productId, LocalDateTime date);

}

package es.technical.test.microservices.prices.domain.service;

import es.technical.test.microservices.prices.domain.Price;
import es.technical.test.microservices.prices.domain.repository.PriceRepository;

import java.time.LocalDateTime;

/**
 * Price Service.
 */
public class DomainPriceService implements PriceService {

    private final PriceRepository priceRepository;

    public DomainPriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    /**
     * Find information on the applicable price of a product based on the group&#39;s brand and an application date.
     *
     * @param brandId   Brand ID (required)
     * @param productId Product ID (required)
     * @param date      Date of application of the product&#39;s price (required)
     * @return {@link Price}
     */
    @Override
    public Price findProductPriceByBrandIdAndDate(Long brandId, Long productId, LocalDateTime date) {
        return priceRepository.findProductPriceByBrandIdAndDate(brandId, productId, date);
    }

}

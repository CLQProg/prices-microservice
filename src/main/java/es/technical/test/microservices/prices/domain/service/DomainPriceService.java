package es.technical.test.microservices.prices.domain.service;

import es.technical.test.microservices.prices.domain.Price;
import es.technical.test.microservices.prices.domain.repository.PriceRepository;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

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
        Set<Price> prices = priceRepository.findProductPriceByBrandIdAndDate(brandId, productId, date);
        Optional<Price> priceMaxPriority = prices.stream().max(Comparator.comparingLong(Price::getPriority));
        return priceMaxPriority.orElse(null);
    }

}

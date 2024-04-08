package es.technical.test.microservices.prices.infrastructure.repository.h2;


import es.technical.test.microservices.prices.domain.Price;
import es.technical.test.microservices.prices.domain.repository.PriceRepository;
import es.technical.test.microservices.prices.infrastructure.repository.h2.mapper.PriceH2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Price entity repository.
 */
@Component
public class H2PriceEntityRepository implements PriceRepository {

    private final SpringDataH2PriceEntityRepository priceRepository;
    private final PriceH2Mapper priceH2Mapper;

    @Autowired
    private H2PriceEntityRepository(SpringDataH2PriceEntityRepository priceRepository, PriceH2Mapper priceH2Mapper) {
        this.priceRepository = priceRepository;
        this.priceH2Mapper = priceH2Mapper;
    }

    /**
     * Find information on the applicable price of a product based on the group&#39;s brand and an application date.
     *
     * @param brandId   Brand ID (required)
     * @param productId Product ID (required)
     * @param date      Date of application of the product&#39;s price (required)
     * @return {@link Price}.
     */
    @Override
    public Price findProductPriceByBrandIdAndDate(Long brandId, Long productId, LocalDateTime date) {
        return priceRepository.findByBrandAndProductAndDateWithMaxPriority(brandId, productId, date)
                .map(priceH2Mapper::toDomainEntity)
                .orElse(null);
    }

}

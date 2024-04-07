package es.technical.test.microservices.prices.infrastructure.repository.h2;


import es.technical.test.microservices.prices.domain.Price;
import es.technical.test.microservices.prices.domain.repository.PriceRepository;
import es.technical.test.microservices.prices.infrastructure.repository.h2.entity.PriceEntity;
import es.technical.test.microservices.prices.infrastructure.repository.h2.mapper.PriceH2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
     * @return {@link Set} of {@link Price}s.
     */
    @Override
    public Set<Price> findProductPriceByBrandIdAndDate(Long brandId, Long productId, LocalDateTime date) {

        Specification<PriceEntity> spec = Specification
                .where(priceRepository.hasProductWithId(productId))
                .and(priceRepository.hasBrandWithId(brandId))
                .and(priceRepository.hasEndDateGreaterThan(date))
                .and(priceRepository.hasStartDateLessThan(date));
        List<PriceEntity> priceEntities = priceRepository.findAll(spec);

        return priceEntities.stream()
                .map(priceH2Mapper::toDomainEntity)
                .collect(Collectors.toSet());
    }

}

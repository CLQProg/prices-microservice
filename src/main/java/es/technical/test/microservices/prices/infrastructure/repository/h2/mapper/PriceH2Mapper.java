package es.technical.test.microservices.prices.infrastructure.repository.h2.mapper;

import es.technical.test.microservices.prices.domain.Price;
import es.technical.test.microservices.prices.infrastructure.repository.h2.entity.PriceEntity;
import org.mapstruct.Mapper;

/**
 * Price mapper.
 */
@Mapper(componentModel = "spring")
public abstract class PriceH2Mapper {

    public abstract Price toDomainEntity(PriceEntity priceEntity);

}

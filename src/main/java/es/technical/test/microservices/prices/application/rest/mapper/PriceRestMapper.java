package es.technical.test.microservices.prices.application.rest.mapper;

import es.technical.test.microservices.prices.domain.Price;
import es.technical.test.microservices.prices.openapi.model.PriceDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Price mapper.
 */
@Mapper(componentModel = "spring")
public abstract class PriceRestMapper {

    @Mapping(target = "priceList", source = "price.id")
    @Mapping(target = "price", source = "price.finalPrice")
    @Mapping(target = "endDate", source = "price.endDate", qualifiedByName = "localDateTimeToString")
    @Mapping(target = "startDate", source = "price.startDate", qualifiedByName = "localDateTimeToString")
    public abstract PriceDto toDto(Price price, Long productId, Long brandId);

    @Named("localDateTimeToString")
    public static String localDateTimeToString(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss"));
    }

}

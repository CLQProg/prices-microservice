package es.technical.test.microservices.prices.application.rest.controller;


import es.technical.test.microservices.prices.application.rest.mapper.PriceRestMapper;
import es.technical.test.microservices.prices.domain.Price;
import es.technical.test.microservices.prices.domain.exceptions.BadRequestException;
import es.technical.test.microservices.prices.domain.exceptions.NotFoundException;
import es.technical.test.microservices.prices.domain.service.PriceService;
import es.technical.test.microservices.prices.openapi.api.PricesApiDelegate;
import es.technical.test.microservices.prices.openapi.model.PriceDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Price API delegate implementation.
 */
@Slf4j
@Service
public class PriceRestApiDelegateImpl implements PricesApiDelegate {

    private final PriceService priceService;
    private final PriceRestMapper priceRestMapper;


    @Autowired
    public PriceRestApiDelegateImpl(PriceService priceService, PriceRestMapper priceRestMapper) {
        this.priceService = priceService;
        this.priceRestMapper = priceRestMapper;
    }

    /**
     * Find information on the applicable price of a product based on the group&#39;s brand and an application date.
     *
     * @param brandId   Brand ID (required)
     * @param productId Product ID (required)
     * @param date      Date of application of the product&#39;s price (required)
     * @return {@link ResponseEntity} of {@link PriceDto}
     */
    @Override
    public ResponseEntity<PriceDto> findProductPriceByBrandIdAndDate(Long brandId, Long productId, String date) {
        log.info("Searching price with brand ID {}, product ID {} and date {}", brandId, productId, date);
        LocalDateTime localDateTime;
        try {
            localDateTime = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss"));
        } catch (DateTimeParseException ex) {
            log.info("The date {} was not in the correct format", date);
            throw new BadRequestException("400", "The date was not in the correct format");
        }
        Price price = priceService.findProductPriceByBrandIdAndDate(brandId, productId, localDateTime);
        if (price == null) {
            log.info("Price with brand ID {}, product ID {} and date {} not found", brandId, productId, date);
            throw new NotFoundException("404", "Price not found");
        }
        log.info("Returning Price with brand ID {}, product ID {} and date {}", brandId, productId, date);
        return ResponseEntity.ok(priceRestMapper.toDto(price, productId, brandId));
    }

}

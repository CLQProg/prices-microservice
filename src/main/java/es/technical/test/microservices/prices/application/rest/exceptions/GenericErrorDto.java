package es.technical.test.microservices.prices.application.rest.exceptions;

import es.technical.test.microservices.prices.infrastructure.configuration.RestExceptionHandler;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Generic Error Dto returned by
 * the {@link RestExceptionHandler}.
 */
@Getter
@AllArgsConstructor
@ToString
public class GenericErrorDto {

    private final String code;
    private final String information;

}

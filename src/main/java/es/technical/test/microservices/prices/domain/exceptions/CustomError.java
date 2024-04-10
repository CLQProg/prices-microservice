package es.technical.test.microservices.prices.domain.exceptions;

import es.technical.test.microservices.prices.application.rest.exceptions.RestExceptionHandler;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Custom Error returned by the {@link RestExceptionHandler}.
 */
@Getter
@AllArgsConstructor
@ToString
public class CustomError {

    private final String code;
    private final String information;

}

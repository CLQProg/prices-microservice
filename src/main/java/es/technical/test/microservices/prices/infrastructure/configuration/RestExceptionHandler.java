package es.technical.test.microservices.prices.infrastructure.configuration;

import es.technical.test.microservices.prices.application.rest.exceptions.GenericErrorDto;
import es.technical.test.microservices.prices.domain.exceptions.GenericException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * REST service exception handler.
 */
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handle a GenericException as defined error condition.
     *
     * @param ex      the exception thrown.
     * @param request the request in which context the exception has been thrown.
     * @return the entity that wraps de JSON error response.
     */
    @ExceptionHandler(value = {GenericException.class})
    public ResponseEntity<Object> handleGenericException(GenericException ex, WebRequest request) {
        final HttpStatus status = ex.getHttpStatus();
        log.info(ex.getMessage(), ex);
        GenericErrorDto genericException = new GenericErrorDto(ex.getCode(), ex.getInformation());
        return handleExceptionInternal(ex, genericException, new HttpHeaders(), status, request);
    }

}

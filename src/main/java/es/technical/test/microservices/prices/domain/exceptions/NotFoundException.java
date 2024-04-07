package es.technical.test.microservices.prices.domain.exceptions;

import org.springframework.http.HttpStatus;

/**
 * Not found exception.
 */
public class NotFoundException extends GenericException {


    /**
     * Not found exception constructor.
     *
     * @param message message.
     * @param code    code.
     */
    public NotFoundException(String code, String message) {
        super(HttpStatus.NOT_FOUND, code, message);
    }
}

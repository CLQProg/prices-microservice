package es.technical.test.microservices.prices.domain.exceptions;

import org.springframework.http.HttpStatus;

/**
 * Bad request exception.
 */
public class BadRequestException extends GenericException {


    /**
     * Bad request exception constructor.
     *
     * @param message message.
     * @param code    code.
     */
    public BadRequestException(String code, String message) {
        super(HttpStatus.BAD_REQUEST, code, message);
    }
}

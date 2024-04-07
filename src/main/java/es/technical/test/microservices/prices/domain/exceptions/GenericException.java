package es.technical.test.microservices.prices.domain.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Generic exception.
 */
@Getter
public class GenericException extends RuntimeException {

    /**
     * The HTTP status to return if the exception is thrown in a REST operation context.
     */
    private final HttpStatus httpStatus;

    /**
     * Code.
     */
    private final String code;

    /**
     * Information.
     */
    private final String information;

    /**
     * Generic Exception constructor.
     *
     * @param message    message.
     * @param httpStatus http status.
     * @param code       code.
     */
    public GenericException(HttpStatus httpStatus, String code, String message) {
        super(message);
        this.httpStatus = httpStatus;
        this.code = code;
        this.information = message;
    }
}

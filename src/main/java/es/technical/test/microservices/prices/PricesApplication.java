package es.technical.test.microservices.prices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Prices application.
 */
@SpringBootApplication(scanBasePackages = "es.technical.test.microservices.prices.*")
public class PricesApplication {

    /**
     * Main method.
     *
     * @param args Arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(PricesApplication.class, args);
    }

}

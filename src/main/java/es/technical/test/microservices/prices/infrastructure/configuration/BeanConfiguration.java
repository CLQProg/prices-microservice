package es.technical.test.microservices.prices.infrastructure.configuration;


import es.technical.test.microservices.prices.domain.repository.PriceRepository;
import es.technical.test.microservices.prices.domain.service.DomainPriceService;
import es.technical.test.microservices.prices.domain.service.PriceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public PriceService priceService(final PriceRepository priceRepository) {
        return new DomainPriceService(priceRepository);
    }

}

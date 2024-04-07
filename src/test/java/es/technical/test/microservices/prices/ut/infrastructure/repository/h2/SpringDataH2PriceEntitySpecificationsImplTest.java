package es.technical.test.microservices.prices.ut.infrastructure.repository.h2;

import es.technical.test.microservices.prices.infrastructure.repository.h2.SpringDataH2PriceEntitySpecificationsImpl;
import es.technical.test.microservices.prices.infrastructure.repository.h2.entity.PriceEntity;
import es.technical.test.microservices.prices.ut.UnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class SpringDataH2PriceEntitySpecificationsImplTest extends UnitTest {

    private final SpringDataH2PriceEntitySpecificationsImpl priceSpecification = new SpringDataH2PriceEntitySpecificationsImpl();

    @BeforeEach
    void setUp() {

    }

    @Test
    void testHasProductWithId() {
        Specification<PriceEntity> spec = priceSpecification.hasProductWithId(123L);
        assertNotNull(spec);
    }

    @Test
    void testHasBrandWithId() {
        Specification<PriceEntity> spec = priceSpecification.hasBrandWithId(456L);
        assertNotNull(spec);
    }

    @Test
    void testHasStartDateLessThan() {
        Specification<PriceEntity> spec = priceSpecification.hasStartDateLessThan(LocalDateTime.now());
        assertNotNull(spec);
    }

    @Test
    void testHasEndDateGreaterThan() {
        Specification<PriceEntity> spec = priceSpecification.hasEndDateGreaterThan(LocalDateTime.now());
        assertNotNull(spec);
    }
}

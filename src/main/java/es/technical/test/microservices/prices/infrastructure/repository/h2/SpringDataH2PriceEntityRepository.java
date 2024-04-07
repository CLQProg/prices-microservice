package es.technical.test.microservices.prices.infrastructure.repository.h2;


import es.technical.test.microservices.prices.infrastructure.repository.h2.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * {@link PriceEntity} H2 repository.
 */
@Repository
public interface SpringDataH2PriceEntityRepository extends JpaRepository<PriceEntity, Long>,
        JpaSpecificationExecutor<PriceEntity>, SpringDataH2PriceEntitySpecifications {

}

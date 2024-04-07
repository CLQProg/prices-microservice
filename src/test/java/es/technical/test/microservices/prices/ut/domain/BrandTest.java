package es.technical.test.microservices.prices.ut.domain;

import es.technical.test.microservices.prices.domain.Brand;
import es.technical.test.microservices.prices.domain.Product;
import es.technical.test.microservices.prices.ut.UnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BrandTest extends UnitTest {

    private Product product;
    private Brand brand;


    @BeforeEach
    void setUp() {
        product = this.getPodamFactory().manufacturePojo(Product.class);
        brand = this.getPodamFactory().manufacturePojo(Brand.class);
    }

    @Test
    void testAddProduct() {
        brand.addProduct(product);
        assertTrue(brand.getProducts().contains(product));
    }

    @Test
    void testRemoveProduct() {
        brand.addProduct(product);
        brand.removeProduct(product);
        assertFalse(brand.getProducts().contains(product));
    }
}

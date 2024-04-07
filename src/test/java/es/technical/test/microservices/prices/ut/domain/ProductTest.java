package es.technical.test.microservices.prices.ut.domain;

import es.technical.test.microservices.prices.domain.Brand;
import es.technical.test.microservices.prices.domain.Price;
import es.technical.test.microservices.prices.domain.Product;
import es.technical.test.microservices.prices.ut.UnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProductTest extends UnitTest {

    private Product product;
    private Brand brand;
    private Price price;

    @BeforeEach
    void setUp() {
        product = this.getPodamFactory().manufacturePojo(Product.class);
        brand = this.getPodamFactory().manufacturePojo(Brand.class);
        price = this.getPodamFactory().manufacturePojo(Price.class);
    }

    @Test
    void testAddBrand() {
        product.addBrand(brand);
        assertTrue(product.getBrands().contains(brand));
    }

    @Test
    void testRemoveBrand() {
        product.addBrand(brand);
        product.removeBrand(brand);
        assertFalse(product.getBrands().contains(brand));
    }

    @Test
    void testAddPrice() {
        product.addPrice(price);
        assertTrue(product.getPrices().contains(price));
    }

    @Test
    void testRemovePrice() {
        product.addPrice(price);
        product.removePrice(price);
        assertFalse(product.getPrices().contains(price));
    }
}

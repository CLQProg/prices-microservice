package es.technical.test.microservices.prices.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

/**
 * Brand that belongs to the group. Each one has several {@link Product}s.
 */
@Builder
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Brand {

    @Getter
    Long id;

    @Getter
    String name;

    Set<Product> products = new HashSet<>();

    public Set<Product> getProducts() {
        return Set.copyOf(products);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

}

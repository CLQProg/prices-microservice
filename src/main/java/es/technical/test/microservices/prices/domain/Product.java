package es.technical.test.microservices.prices.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

/**
 * Product. Each one belongs to a {@link Brand} and has a set of possible {@link Price}s.
 */
@Builder
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Product {


    @Getter
    String id;

    @Getter
    String name;

    Set<Brand> brands = new HashSet<>();

    Set<Price> prices = new HashSet<>();


    public Set<Brand> getBrands() {
        return Set.copyOf(brands);
    }

    public void addBrand(Brand brand) {
        this.brands.add(brand);
    }

    public void removeBrand(Brand brand) {
        this.brands.remove(brand);
    }


    public Set<Price> getPrices() {
        return Set.copyOf(prices);
    }

    public void addPrice(Price price) {
        this.prices.add(price);
    }

    public void removePrice(Price price) {
        this.prices.remove(price);
    }

}

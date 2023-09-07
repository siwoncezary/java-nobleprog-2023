package pl.nobleprog.advanced.day1.c4factory.demo;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.function.BiFunction;

public enum Electronics {
    LAPTOP((price, name) -> new Laptop(price, name)),
    MOBILE((price, name) -> new MobilePhone(price, name));

    private BiFunction<BigDecimal, String, Product> producer;

    Electronics(BiFunction<BigDecimal, String, Product> producer){
        this.producer = producer;
    }

    public static Optional<Product> getProduct(String type, BigDecimal price, String name){
        try {
            return Optional.ofNullable(Electronics.valueOf(type.toUpperCase()).producer.apply(price, name));
        } catch (IllegalArgumentException e){
            return Optional.empty();
        }
    }
}

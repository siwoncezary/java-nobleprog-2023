package pl.nobleprog.advanced.day1.c4factory.demo;

import java.math.BigDecimal;
import java.util.Optional;

public abstract class AbstractProductFactory {
    public  abstract Optional<Product> getProduct(String type, BigDecimal price, String name);
}

package pl.nobleprog.advanced.day1.c4factory.demo;

import java.math.BigDecimal;
import java.util.Optional;

public class ElectronicProductFactory extends AbstractProductFactory {
    @Override
    public Optional<Product> getProduct(String type, BigDecimal price, String name) {
        switch (type){
            case "laptop":
                return Optional.ofNullable(new Laptop(price, name));
            case "mobile":
                return Optional.ofNullable(new MobilePhone(price, name));
        }
        return Optional.empty();
    }
}

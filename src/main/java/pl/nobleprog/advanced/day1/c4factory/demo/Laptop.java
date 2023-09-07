package pl.nobleprog.advanced.day1.c4factory.demo;

import java.math.BigDecimal;

public class Laptop implements Product{
    private BigDecimal price;
    private String name;

    public Laptop(BigDecimal price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public BigDecimal price() {
        return price;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}

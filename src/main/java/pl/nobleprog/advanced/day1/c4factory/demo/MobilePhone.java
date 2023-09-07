package pl.nobleprog.advanced.day1.c4factory.demo;

import java.math.BigDecimal;

public class MobilePhone implements Product{
    private BigDecimal price;
    private String name;

    public MobilePhone(BigDecimal price, String name) {
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
        return "MobilePhone{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}

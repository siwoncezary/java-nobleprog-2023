package pl.nobleprog.advanced.day1.c4factory.demo;

import java.math.BigDecimal;

public class FactoryMethodDemo {
    public static void main(String[] args) {
        //Fabryka dostarczająca metodę wytwórczą
        AbstractProductFactory factory = new ElectronicProductFactory();
        System.out.println(factory.getProduct("laptop", new BigDecimal("2540"),"Lenovo"));
        System.out.println(factory.getProduct("mobile", new BigDecimal("1240"),"Xiaomi"));
        //Typ enum z metodami wytwórczymi
        System.out.println(Electronics.getProduct("dysk", new BigDecimal("2540"),"Lenovo"));
        System.out.println(Electronics.getProduct("mobile", new BigDecimal("1240"),"Xiaomi"));
    }
}

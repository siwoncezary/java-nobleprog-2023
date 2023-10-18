package pl.nobleprog.advanced.day1.c2interface;

import pl.nobleprog.advanced.day1.c1abstraction.Laptop;
import pl.nobleprog.advanced.day1.c1abstraction.Product;

public class Demo {
    public static void main(String[] args) {
        // interface declaration

        // interface static fields

        // interface instance method

        // interface static method

        // interface private instance method

        // interface instance default method

        // interface inheritance

        // interface implementation

        ProductService service = new MemoryProductService();
        // business logic
        int id = service.saveProduct(new Laptop("laptop",1000000,16,"i7"));
        System.out.println(service.getById(id).info());
        Product product = service.sellProductById(1);
        System.out.println(service.getById(1));
    }
}

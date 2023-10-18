package pl.nobleprog.advanced.day1.c1abstraction;

public abstract class Product {
    private final String name;
    private final int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public abstract String info();

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

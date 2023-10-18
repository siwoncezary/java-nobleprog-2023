package pl.nobleprog.advanced.day1.c1abstraction;

public class Laptop extends Product{

    private final int ram;

    private final String cpu;

    public Laptop(String name, int price, int ram, String cpu) {
        super(name, price);
        this.ram = ram;
        this.cpu = cpu;
    }

    @Override
    public String info() {
        return String.format("%s %d %s %d", getName(), getPrice(), cpu, ram);
    }
}

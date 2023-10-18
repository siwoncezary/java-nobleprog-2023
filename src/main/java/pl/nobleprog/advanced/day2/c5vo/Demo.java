package pl.nobleprog.advanced.day2.c5vo;

public class Demo {
    public static void main(String[] args) {
        // what is ValueObject
        Money m= Money.of(1000, Currency.PLN);
        System.out.println(m.percent(33));
    }
}

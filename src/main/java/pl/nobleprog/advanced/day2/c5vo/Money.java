package pl.nobleprog.advanced.day2.c5vo;

public class Money {
    public final int amount;

    public final Currency currency;

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency=" + currency +
                '}';
    }

    private Money(int amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money of(int amount, Currency currency){
        if (amount < 0){
            throw new IllegalArgumentException("ujemna kwota");
        }
        return new Money(amount, currency);
    }

    public Money add(Money arg){
        if (arg.currency == currency){
            return Money.of(arg.amount + amount, arg.currency);
        }
        throw new IllegalArgumentException("niezgodnosc walut");
    }

    /**
     * Zdefiniuj metode mnozaca kwote przez procent w argumnecie
     */
    public Money percent(double percent){
        return Money.of((int) Math.round(amount * percent / 100), currency);
    }
}

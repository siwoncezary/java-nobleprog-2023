package pl.nobleprog.advanced.day1.c4factory;

import java.text.NumberFormat;
import java.util.Locale;

public class Demo {
    public static void main(String[] args) {
        // idea of factory pattern

        // abstract factory method
    }

    public static void examples(){
        // method getXXX is factory method in NumberFormat class
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pl-PL"));

        // method valueOf is factory method in boxed classes
        Boolean booleanValue = Boolean.valueOf("true");
                  Boolean booleanVal = Boolean.valueOf(false);
    }
}

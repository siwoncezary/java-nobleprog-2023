package pl.nobleprog.fundamentals.day2.c7utils.formatters;

import java.awt.font.NumericShaper;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Currency;
import java.util.Locale;

public class Demo {
    public static void main(String[] args) {
        // String.format()
        System.out.println(String.format("%10.2f | %-10s | %04X", 1256.56, "Laptop", 123));
        System.out.println(String.format("%10.2f | %-10s | %04X", 124.4, "Monitor", 18798));

        // System.out.printf()
        System.out.printf("%10.2f | %-10s | %04X\n", 1256.56, "Laptop", 123);
        System.out.println(String.format("%10.2f | %-10s | %04X", 124.4, "Monitor", 18798));

        // NumberFormat - currency
        final NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.UK);
        System.out.println(currencyFormatter.format(10));

        // NumberFormat - number
        final NumberFormat numberFormatter = NumberFormat.getNumberInstance(Locale.forLanguageTag("pl-PL"));
        System.out.println(numberFormatter.format(10223823923L));

        // NumberFormat - percent
        final NumberFormat percentFormatter = NumberFormat.getPercentInstance(Locale.getDefault());
        System.out.println(percentFormatter.format(0.2345));

        //DateTimeFormatter
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy:HH:mm:ss");
        System.out.println(formatter.format(LocalDateTime.now()));
    }
}

package pl.nobleprog.fundamentals.day2.c7utils.locales;

import java.text.Collator;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Locale;

public class Demo {
    public static void main(String[] args) {
        // Locale build
        final Locale plLocale = new Locale.Builder()
                .setLanguage("pl")
                .setRegion("PL")
                .setScript("Latn")
                .build();
        System.out.println(plLocale.getISO3Country());

        // Locale
        Locale locale = Locale.forLanguageTag("pl-PL");
        System.out.println(locale.getCountry());
        System.out.println(locale.getDisplayCountry());

        // Collator
        Collator collator = Collator.getInstance(locale);

        // sortowanie
        String [] names = { "Łukasz", "Beata", "Ewa", "Adam", "Żaneta", "Robert"};
        Arrays.sort(names, collator);
        System.out.println(Arrays.toString(names));
    }
}

package pl.nobleprog.advanced.day2.c4regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
    public static void main(String[] args) {
        // Patter class
        Pattern pattern = Pattern.compile("\\d\\d");
        // Matcher class
        Matcher matcher = pattern.matcher("askjdh 23-456 sdf sdf");
        // pattern matching
        System.out.println("Czy lancuch pasuje do wzorca? " + matcher.matches());
        while(matcher.find()){
            System.out.println("Znaleziono dwie cyfry");
            System.out.println(matcher.group());
        }
        // group extraction
        pattern = Pattern.compile("(?<two>\\d{2})-(?<three>\\d{3})");
        matcher = pattern.matcher("Kod pocztowy 25-890 Warszawa; 45-789 Wrocław 78 567");
        StringBuilder sb = new StringBuilder();
        while(matcher.find()){
            System.out.println(matcher.group("two") + "-" + matcher.group("three"));
            System.out.println("Liczba grup: " + matcher.groupCount());
            System.out.println("Pozycja znaku za wzorcem " + matcher.end());
            matcher.appendReplacement(sb, "<kod pocztowy>");
        }
        matcher.appendTail(sb);
        System.out.println(sb);
        // groupReplacement();
        System.out.println("Group replacement");
        matcher = pattern.matcher("Kod pocztowy 25-890 Warszawa; 45-789 Wrocław 78 567");
        if(matcher.find()){
            var str = matcher.replaceAll("<kod pocztowy>");
            System.out.println(str);
        }
    }
}

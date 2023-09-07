package pl.nobleprog.advanced.day2.c4regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
    public static void main(String[] args) {
        // Patter class

        // Matcher class

        // pattern matching
        groupFind();

        // group extraction
        // groupReplacement();
    }

    public static void patternMatches(){
        Pattern pattern = Pattern.compile("\\d\\d");
        Matcher matcher = pattern.matcher("23 456 abcd");
        System.out.println("Czy łańcuch pasuje do wzoru? " + matcher.matches());
    }

    public static void patternFind(){
        Pattern pattern = Pattern.compile("\\d\\d");
        Matcher matcher = pattern.matcher("23 456 abcd");
        while(matcher.find()){
            System.out.println("Wystąpienie wzorca - dwie kolejne cyfry!");
            System.out.println(matcher.group());
            System.out.println(matcher.groupCount());
        }
    }

    public static void groupFind(){
        Pattern pattern = Pattern.compile("(?<two>\\d\\d)-(?<three>\\d{3})");
        Matcher matcher = pattern.matcher("23-456 abcd psdjs osdfj odifj . sd8 990 sd0 78 987 45-998");
        StringBuilder sb = new StringBuilder();
        while(matcher.find()){
            System.out.println("Wystąpienie wzorca kodu pocztowego!");
            System.out.println("Pierwsza grupa kodu: " + matcher.group("two"));
            System.out.println("Druga grupa kodu: " + matcher.group("three"));
            System.out.println("Liczba brup wzorca: " + matcher.groupCount());
            System.out.println("Pozycja znaku za wzorcem: " + matcher.end());
            matcher.appendReplacement(sb, "<kod pocztowy>");
        }
        matcher.appendTail(sb);
        System.out.println(sb);
    }

    public static void groupReplacement(){
        Pattern pattern = Pattern.compile("(?<two>\\d\\d)-(?<three>\\d{3})");
        String input = "23-456 abcd psdjs osdfj odifj . sd8 990 sd0 78 987 45-998 dasd 6 1890.";
        Matcher matcher = pattern.matcher(input);
        StringBuilder sb = new StringBuilder();
        while(matcher.find()){
            System.out.println("Input after replacement: " + matcher.replaceAll("<kod pocztowy>"));
        }
    }
}

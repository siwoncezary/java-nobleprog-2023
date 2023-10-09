package pl.nobleprog.advanced.day2.c3strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.StringJoiner;

public class Demo {
    public static void main(String[] args) {
        // StringBuilder class  - don't use as shared object in multithreaded code!

        // StringBuffer class - safe concurrency class

        measureTime("StringBuilder", () -> joinByStringBuilder());

        // join method in String class

        measureTime("Join method", () -> joinByJoinMethod());

        // StringJoiner class

        measureTime("StringJoiner", () -> joinByStringJoiner());

        // string concatenation

        measureTime("String concatenation (only 100 000)", () -> joinByConcatenation());

        // selected String methods

        System.out.println("#".repeat(5));
        String str = "\uD83D\uDE01Łąka";
        System.out.println(str);
        System.out.println("Code point at 0: " + str.codePointAt(0));
        System.out.println("Char at 0: " + str.charAt(0));
        System.out.println("Char at 1: " + str.charAt(1));
        System.out.println("Char at 2: " + str.charAt(2));
        System.out.println("Byte array: " + Arrays.toString(str.getBytes()));
        System.out.println("Intern: " + str.intern());

        String escaped = "  \tABCD\n  EFGH\b\"\'".translateEscapes();
        System.out.println("Original string:");
        System.out.println(escaped);
        System.out.println("Ident:");
        System.out.println(escaped.indent(5));
        System.out.println("StripLeading:");
        System.out.println(escaped.stripLeading());
        System.out.println("StripIdent:");
        System.out.println(escaped.stripIndent());
        System.out.println("Transform:");
        System.out.println((String) escaped.transform(String::toLowerCase));

        String format = "%20s %5.2f";
        var data = new HashMap<String, Double>(){{
            put("Lampa", 24.6788);
            put("Stolik", 624.98978);
            put("Fotel", 324.1234);
            put("Sofa", 924.2318);
        }};
        data.forEach((key, value) -> System.out.println(format.formatted(key, value)));
    }

    public static void joinByStringBuilder(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 1_000_000; i++){
            sb.append("A");
        }
    }

    public static void joinByJoinMethod(){
        String[] arr = new String[1_000_000];
        Arrays.fill(arr, "A");
        String result = "";
        result = String.join("", arr);
    }

    public static void joinByStringJoiner(){
        StringJoiner joiner = new StringJoiner("");
        for(int i = 0; i < 1_000_000; i++){
            joiner.add("A");
        }
    }

    public static void joinByConcatenation(){
        String str = "";
        for(int i = 0; i < 100_000; i++){
            str += "A";
        }
    }

    public static void measureTime(String message, Runnable task){
        long startTime = System.nanoTime();
        task.run();
        long stopTime = System.nanoTime();
        System.out.print(message);
        System.out.println(" time: " + (stopTime - startTime)/1_000_000 + " ms");
    }
}

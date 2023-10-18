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
        // measureTime("String concatenation (only 100 000)", () -> joinByConcatenation());

        // StringBuffer
        measureTime("StringBuffer", Demo::joinByStringBuffer);

        // selected String methods

        String str = "\uD83D\uDE01lalka";
        System.out.println(str);
        System.out.println(str.charAt(0));
        System.out.println(str.charAt(2));
        System.out.println(str.codePointAt(0));
        System.out.println(str.codePointAt(1));
        System.out.println((char) str.codePointAt(2));
        System.out.println(str.intern());

        System.out.println(str.indent(5));
        System.out.println((" " + str).stripLeading());
        String format = "%-20s %7.2f\n";
        var data = new HashMap<String, Double>() {{
            put("Lampa", 24.56678);
            put("Stolik", 35.66789);
            put("Fotel", 456.789945);
        }};
        data.forEach((key, val) -> System.out.print(format.formatted(key, val)));
    }

    public static String joinByStringBuffer() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 1_000_000; i++) {
            sb.append("A");
        }
        return sb.toString();
    }

    public static String joinByStringBuilder() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1_000_000; i++) {
            sb.append("A");
        }
//        sb.append('2').append(2).append(System.lineSeparator());
//        new StringBuilder("abcd").reverse().toString()
        return sb.toString();
    }

    public static void joinByJoinMethod() {
        String[] arr = new String[1_000_000];
        Arrays.fill(arr, "A");
        String result = "";
        result = String.join("", arr);
    }

    public static void joinByStringJoiner() {
        StringJoiner joiner = new StringJoiner("");
        for (int i = 0; i < 1_000_000; i++) {
            joiner.add("A");
        }
    }

    public static void joinByConcatenation() {
        String str = "";
        for (int i = 0; i < 100_000; i++) {
            str += "A";
        }
    }

    public static void measureTime(String message, Runnable task) {
        long startTime = System.nanoTime();
        task.run();
        long stopTime = System.nanoTime();
        System.out.print(message);
        System.out.println(" time: " + (stopTime - startTime) / 1_000_000 + " ms");
    }
}

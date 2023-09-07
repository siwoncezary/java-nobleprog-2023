package pl.nobleprog.advanced.day2.c3strings;

import java.util.Arrays;
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
    }

    public static void joinByStringBuilder(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 1_000_000; i++){
            sb.append("A");
        }
        System.out.println(sb.toString().length());
    }

    public static void joinByJoinMethod(){
        String[] arr = new String[1_000_000];
        Arrays.fill(arr, "A");
        String result = "";
        result = String.join("", arr);
        System.out.println(result.length());
    }

    public static void joinByStringJoiner(){
        StringJoiner joiner = new StringJoiner("");
        for(int i = 0; i < 1_000_000; i++){
            joiner.add("A");
        }
        System.out.println(joiner.toString().length());
    }

    public static void measureTime(String message, Runnable task){
        long startTime = System.nanoTime();
        task.run();
        long stopTime = System.nanoTime();
        System.out.print(message);
        System.out.println(" time: " + (stopTime - startTime)/1_000_000 + " ms");
    }
}

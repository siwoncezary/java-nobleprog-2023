package pl.nobleprog.advanced.day2.c3strings;

import java.util.Objects;

public class StringDemo {
    public static void main(String[] args) {
        String str = """
                Wiersz 1
                Wiersz 2
                Wiersz '3'
                """;
        System.out.println(str);
        System.lineSeparator();
        String a = "abcd";
        String b = "abcd";
        System.out.println(a == b);
        String c = new String("abcd");
        System.out.println(a == c);
        System.out.println(a.equals(c));
        System.out.println(Objects.equals(a, c));
        String e = "ab";
        String f = "cd";
        String h = e + f;
        System.out.println((e + f) == a);
        System.out.println(h);
        System.out.println(h == a);
        System.out.println("x".repeat(5));
        System.out.println("1" + 1);
        System.out.println(Integer.parseInt("1") * 1);
    }
}

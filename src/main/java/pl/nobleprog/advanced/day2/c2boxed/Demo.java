package pl.nobleprog.advanced.day2.c2boxed;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Demo {
    public static void main(String[] args) {

        // boxing primitive types
        Integer a = 450;
        Integer b = Integer.valueOf(450);
        int c = 50;
        Double f = 56.09;
        Boolean h = true;
        // unboxing primitive types
        System.out.println(c == a);
        System.out.println(c == a.intValue());
        // static methods
        System.out.println(Integer.compare(34, a));
        System.out.println(Integer.toHexString(a));
        System.out.println(Integer.decode("0x17"));
        System.out.println(Integer.toBinaryString(Integer.reverse(a)));
        // instance method
        System.out.println(a.doubleValue());
        // pitfalls

        // int values are pooled in range from -128 to 127
        System.out.println(a == b);                 // porownanie referencji

        // operator `==` can compare boxed integer only in byte range

        // other values are not pooled, and can't be compared by '=='
        // in this case we compare references

        // always use `equals`
        // or Objects.equals
        System.out.println(a.equals(b));            // moze byc NPE
        System.out.println(Objects.equals(a, b));   // bez NPE
        // List of boxed integers and remove methods
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(5);
        //ints.remove(0);
        ints.remove(a);
        System.out.println(ints);
        int l = 5;
        int k = 6;
        Long result = calc(null, k);
        System.out.println(result);


    }

    public static Long calc(Integer a, int b){
        if (a != null) {
            return Long.valueOf(a * b);
        } else {
            return null;
        }
    }
}

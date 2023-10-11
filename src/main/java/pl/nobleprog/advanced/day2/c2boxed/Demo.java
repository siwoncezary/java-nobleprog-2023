package pl.nobleprog.advanced.day2.c2boxed;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Demo {
    public static void main(String[] args) {

        // boxing primitive types

        Integer i1 = 12;
        Integer i2 = Integer.valueOf(12);
        System.out.println(i1 == i2);
        int i3 = 12;
        System.out.println(i1 == i3);

        // unboxing primitive types

        System.out.println(i1);
        System.out.println(Integer.compareUnsigned(12, -12));
        System.out.println(Integer.compare(12, -12));

        // static methods

        int a = Integer.parseInt("23");
        System.out.println(Integer.toHexString(a));
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toOctalString(a));
        System.out.println(Integer.bitCount(a));
        System.out.println(Integer.decode("0x17"));
        System.out.println(Integer.reverse(a));

        // instance method

        System.out.println(i1.doubleValue());
        System.out.println(i1.byteValue());

        // pitfalls

        // int values are pooled in range from -128 to 127
        Integer obj1 = 45;
        Integer obj2 = 45;
        Long    obj3 = 45L;

        // operator `==` can compare boxed integer only in byte range
        System.out.println("Comparing boxed types");
        System.out.println(obj1 == obj2);           // true
        System.out.println(obj3 == obj3);

        // other values are not pooled, and can't be compared by '=='
        // in this case we compare references
        obj1 = 678;
        obj2 = 678;

        System.out.println(obj1 == obj2);           // false
        // always use `equals`

        System.out.println(obj1.equals(obj2));      // true
        // or Objects.equals

        System.out.println(Objects.equals(obj1, obj2));

        // List of boxed integers and remove methods
        List<Integer> intList = new ArrayList<>(List.of(1, 2, 3, 4));

        System.out.println(intList.remove(1));              // remove by index or by value ?
        System.out.println(intList);

        System.out.println(intList.remove(Integer.valueOf(1))); // remove by value
        System.out.println(intList);

    }
}

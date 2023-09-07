package pl.nobleprog.advanced.day2.c2boxed;

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
        System.out.println(Integer.toHexString(-12));
        System.out.println(Integer.toHexString(12));

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

    }
}

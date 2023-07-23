package pl.nobleprog.fundamentals.day2.c6modificators;

import pl.nobleprog.fundamentals.day2.c6modificators.data.Person;

import java.lang.reflect.Modifier;

public class Test {
    public static void test() throws NoSuchFieldException {
        Person person = new Person();

        if (Person.class.getDeclaredField("firstName").getModifiers() == Modifier.PUBLIC) {
            System.out.println("Test 1 done, field `firstName` is public.");
        } else {
            System.out.println("Test 1 failed, field `firstName` has wrong modifier!");
        }
        if (Person.class.getDeclaredField("visits").getModifiers() == Modifier.PRIVATE) {
            System.out.println("Test 2 done, field `visits` is private.");
        } else {
            System.out.println("Test 2 failed, field `visits` has wrong modifier!");
        }
        if (Person.class.getDeclaredField("isActive").getModifiers() == Modifier.PROTECTED) {
            System.out.println("Test 3 done, field `isActive` is protected.");
        } else {
            System.out.println("Test 3 failed, field `isActive` has wrong modifier!");
        }
    }
}

package pl.nobleprog.advanced.day1.c2interface.task;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

public class TaskTest {
    public static void test(Object obj) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> clazz = obj.getClass();
        if (!Arrays.stream(clazz.getInterfaces()).anyMatch(i -> Objects.equals(i.getSimpleName(),"History"))){
            System.out.println("Klasa nie implementuje interfejsu History!");
            return;
        }
        if (!Arrays.stream(clazz.getMethods()).anyMatch(m -> Objects.equals(m.getName(), "insert"))
                || !Arrays.stream(clazz.getMethods()).anyMatch(m -> Objects.equals(m.getName(), "last"))){
            System.out.println("Klasa nie posiada metody insert lub last!");
            return;
        }
        Method insert = clazz.getMethod("insert", String.class);
        insert.invoke(obj,"abc");
        insert.invoke(obj,"123");
        insert.invoke(obj,"uuu");
        insert.invoke(obj,"ooo");
        insert.invoke(obj,"vvv");
        insert.invoke(obj,"xxx");
        insert.invoke(obj,"zzz");
        Method last = clazz.getMethod("last", int.class);
        final String[] result = (String[]) last.invoke(obj, 3);
        if(result.length != 3){
            System.out.println("Metoda `last` zwraca niepoprawną liczbę wpisów!");
            return;
        }
        if(
                !Objects.equals(result[0], "zzz")
              ||!Objects.equals(result[1], "xxx")
              ||!Objects.equals(result[2], "vvv")
        ){
            System.out.println("Metoda `last` zwraca niepoprawne wpisy!");
            return;
        }
        System.out.println("Brawo, zadanie wykonane poprawnie!");
    }
}

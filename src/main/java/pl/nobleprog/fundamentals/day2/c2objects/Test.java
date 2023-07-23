package pl.nobleprog.fundamentals.day2.c2objects;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

    public static void  test(Object book){
        if (book.getClass().getSimpleName().equals("Book")){
            System.out.println("Excellent, object is instance of class Book.");
        } else {
            System.out.println("Ups, object is instance of wrong type!");
            return;
        }
        try {
            final Field titleField = book.getClass().getDeclaredField("title");
            System.out.println("Excellent, object has field `title`");
            final Field editionField = book.getClass().getDeclaredField("editionYear");
            System.out.println("Excellent, object has field `editionYear`");
            if (titleField.get(book).equals("Effective Java")){
                System.out.println("Excellent, field `title` has value `Effective Java`");
            } else {
                System.out.println("Ups, no field `title` has wrong value!");
            }
            if ((int) editionField.get(book) == 2022){
                System.out.println("Excellent, field `editionYear` has value `2022`.");
            } else {
                System.out.println("Ups, no field `editionYear` has wrong value!");
            }
            final Method ageMethod = book.getClass().getDeclaredMethod("age", int.class);
            if ((int) ageMethod.invoke(book, 2000) == 22){
                System.out.println("Excellent, method `age` returns `22`.");
            } else {
                System.out.println("Ups, method `age` returns wrong value!");
            }
            System.out.println("Task done!");
        } catch (NoSuchFieldException e){
            System.out.println("Ups, no field `title` or `editionYear`!");
            System.out.println("Task failed!");
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            System.out.println("Ups, no method `age`!");
            System.out.println("Task failed!");
            throw new RuntimeException(e);
        }
    }
}

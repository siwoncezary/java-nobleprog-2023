package pl.nobleprog.fundamentals.day2.c7utils.dates;

import java.time.LocalDate;

public class Test {
    public static void test(){
        final boolean result1 = Task.isBirthDay(
                LocalDate.of(2000, 11, 4),
                LocalDate.of(2023, 11, 4)
        );
        final boolean result2 = Task.isBirthDay(
                LocalDate.of(2000, 2, 29),
                LocalDate.of(2023, 2, 28)
        );
        final boolean result3 = Task.isBirthDay(
                LocalDate.of(2000, 2, 28),
                LocalDate.of(2023, 2, 28)
        );
        if (result1 && result2 && result3){
            System.out.println("Task done.");
        } else {
            System.out.println("Task failed!");
        }
    }

}

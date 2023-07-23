package pl.nobleprog.fundamentals.day2.c5array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Test {
    public static void test(){
        int[] test1 = {2, 3, 4, 8, -8, 2, -10, 3, 7, -23};
        Task.evenNumbers(test1);
        if (Arrays.stream(test1).filter(a -> a == -1).count() == 6){
            System.out.println("Task 1 done.");
        } else {
            System.out.println("Task 1 failed!");
        }
        final int[] array = Task.createArray();
        if (Arrays.equals(array, IntStream.iterate(1000, i  -> i - 1).limit(1000).toArray())){
            System.out.println("Task 2 done.");
        } else {
            System.out.println("Task 2 failed!");
        }
        boolean[] test2 = {true, false, true, true, false, true, true};
        if (Task.countTrue(test2) == 5){
            System.out.println("Task 3 done.");
        } else {
            System.out.println("Task 3 failed!");
        }
    }
}

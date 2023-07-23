package pl.nobleprog.fundamentals.day4.c1exceptions;

import java.util.Collections;
import java.util.List;

public class Task {
    public static void main(String[] args) {
        try {
            Quiz quiz = Quiz.of(List.of("2", "3", "6"), Collections.emptyList(), "2 + 5 = ?");
            System.out.println("Oh no, task done incorrectly.");
        } catch (RuntimeException e){
            if (e.getClass().getSimpleName().equals("NoCorrectOptionException")) {
                System.out.println("Ok, task done correctly.");
            } else {
                System.out.println("Oh no, task done incorrectly.");
            }
        }
    }
}

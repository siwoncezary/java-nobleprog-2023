package pl.nobleprog.advanced.day4.c2reflection.task;

import java.util.Arrays;

public class Task {
    int a;

    double b;

    String c;
    public static void main(String[] args) {
        fieldListOfType(new Task(), String.class);
    }

    // zdefiniuj metodę która wyświetli listę nazw pól obiektu obj klasy type
    // np. dla wywołania:
    // fieldListOfType(new Task(), int.class);
    // wyświetli
    // a
    public static void fieldListOfType(Object obj, Class<?> type){
        throw new RuntimeException("Not implemented!");
    }
}

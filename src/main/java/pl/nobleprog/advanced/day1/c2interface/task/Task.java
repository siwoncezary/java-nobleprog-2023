package pl.nobleprog.advanced.day1.c2interface.task;

import java.lang.reflect.InvocationTargetException;

public class Task {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Object history = new ArrayHistory();
        TaskTest.test(history);
    }
}

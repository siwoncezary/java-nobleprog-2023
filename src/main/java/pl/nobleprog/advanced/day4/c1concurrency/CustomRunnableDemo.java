package pl.nobleprog.advanced.day4.c1concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomRunnableDemo {
    public static void main(String[] args) {
        CustomRunnable task = new CustomRunnable("Hello");
        Thread t = new Thread(task);
        t.start();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(task);
        service.execute(task);

        service.execute(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("Lambda");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        service.shutdown();
        service.shutdownNow();
        // utworz dowolny egzekutor i wykonaj zadanie prostej animacji w konsoli
        System.out.print("\b");
    }
}

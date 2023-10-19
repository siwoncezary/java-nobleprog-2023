package pl.nobleprog.advanced.day4.c1concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchronizationDemo {
    public static volatile int  sum;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        Object monitor = new Object();
        service.execute(() -> {
            // 1
            for(int i = 0; i < 100_000; i++){
                synchronized (monitor) {
                    sum += 1;       // sekcja krytyczna
                }
            }
        });
        service.execute(() -> {
            // 2
            for(int i = 0; i < 100_000; i++){
                synchronized (monitor) {
                    sum += 1;       // sekcja krytyczna
                }
            }
        });
        service.shutdown();
        service.awaitTermination(100, TimeUnit.MILLISECONDS);
        System.out.println(sum);
    }
}

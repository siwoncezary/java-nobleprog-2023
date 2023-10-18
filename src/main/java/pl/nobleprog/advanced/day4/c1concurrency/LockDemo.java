package pl.nobleprog.advanced.day4.c1concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    static int sum = 0;
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(() -> {
            // 1
            for (int i = 0; i < 100_000; i++) {
               lock.lock();     // pocztek sekcji
               sum +=1;
               sum +=1;
               lock.unlock();  // koniec
            }
        });
        service.execute(() -> {
            // 2
            for (int i = 0; i < 100_000; i++) {
                lock.lock();
                sum += 1;
                lock.unlock();

            }
        });
        service.shutdown();
        service.awaitTermination(100, TimeUnit.MILLISECONDS);
        System.out.println(sum);
    }
}

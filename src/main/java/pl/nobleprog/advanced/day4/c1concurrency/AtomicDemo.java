package pl.nobleprog.advanced.day4.c1concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    static AtomicInteger sum = new AtomicInteger(0);

    static List<String> list = Collections.synchronizedList(new ArrayList<String>());

    // dodaj dzialanie na StringBuffer w obu watkach
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(() -> {
            // 1
            for (int i = 0; i < 100_000; i++) {
                sum.incrementAndGet();       // sekcja krytyczna
                list.add(Integer.toString(i));
            }
        });
        service.execute(() -> {
            // 2
            for (int i = 0; i < 100_000; i++) {

                sum.incrementAndGet();       // sekcja krytyczna
                list.add(Integer.toString(i));

            }
        });
        service.shutdown();
        service.awaitTermination(100, TimeUnit.MILLISECONDS);
        System.out.println(sum.get());
        System.out.println(list.size());
    }
}

package pl.nobleprog.advanced.day4.c1concurrency;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedulerDemo {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
        System.out.println("Zadanie zaplanowane");
        service.schedule(() -> System.out.println("Tick"), 1000, TimeUnit.MILLISECONDS);
        service.scheduleAtFixedRate(() -> System.out.println("Tack"),0, 2000, TimeUnit.MILLISECONDS);
        service.scheduleWithFixedDelay(() -> System.out.println("Delay"), 0, 3000, TimeUnit.MILLISECONDS);
        Thread.sleep(10000);
        service.shutdown();
        // napisz program, ktory wyswietla zegar z czasem odswiezanym co 1 s
    }
}

package pl.nobleprog.advanced.day4.c1concurrency;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ClockApp {
    static String time;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press q to quit.");
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        time = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss"));
        service.scheduleAtFixedRate(() -> {
            System.out.print("\b".repeat(time.length()));
            time = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss"));
            System.out.print(time);
                }, 0, 200, TimeUnit.MILLISECONDS
        );
        while (true){
            if (scanner.next().equals("q")){
                service.shutdown();
                break;
            }
        }
    }
}

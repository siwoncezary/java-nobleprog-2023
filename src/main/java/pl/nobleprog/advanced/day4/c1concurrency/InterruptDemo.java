package pl.nobleprog.advanced.day4.c1concurrency;

import javax.print.attribute.standard.RequestingUserName;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InterruptDemo {
    static Thread current;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);

        Runnable job = () -> {
          current = Thread.currentThread();
          int i = 100;
          while(i-->0 && !current.isInterrupted()){
              try {
                  Thread.sleep((long) (Math.random()*100));
              } catch (InterruptedException e) {
                  System.out.println("Thread interrupted");
                 break;
              }
              System.out.println("Job " + i);
          }
            System.out.println("Job finished");
        };
        service.execute(job);
        Thread.sleep(1000);
        current.interrupt();
        System.out.println("Interrupt set");
        service.shutdown();

    }
}

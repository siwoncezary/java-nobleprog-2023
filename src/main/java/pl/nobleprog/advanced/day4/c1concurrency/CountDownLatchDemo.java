package pl.nobleprog.advanced.day4.c1concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task implements Runnable{
    private final CountDownLatch latch;
    private final String name;

    Task(CountDownLatch latch, String name) {
        this.latch = latch;
        this.name = name;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(1000 + (int) Math.random() * 10_000);
            System.out.println("Task " + name + " done");
            latch.countDown();
        } catch (InterruptedException e){

        }
    }
}
class CounterMonitor{
    private int counter;
    public synchronized void inc() throws InterruptedException {
        if (counter == 100){
            this.wait();
            counter++;
        } else {
            counter++;
        }
    }

    public synchronized void reset(){
        this.notifyAll();
    }
}
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);
        ExecutorService service = Executors.newFixedThreadPool(5);
        service.execute(new Task( latch, "A"));
        service.execute(new Task( latch, "B"));
        service.execute(new Task( latch, "C"));
        service.execute(new Task( latch, "D"));
        service.execute(new Task( latch, "E"));
        boolean await = latch.await(10_000, TimeUnit.MILLISECONDS);
        if (await){
            System.out.println("All task done");
        } else {
            System.out.println("Timeout! Some task not finished");
        }
        service.shutdown();
    }


    public static void waitAndNotifyDemo() throws InterruptedException {
        CounterMonitor counter = new CounterMonitor();
        Thread t = new Thread(() -> {
            try {
                for (int i = 0 ; i < 200; i++) {
                    counter.inc();
                    System.out.println(i);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("After wait");
        });
        t.start();
        Thread.sleep(2000);
        counter.reset();
    }
}

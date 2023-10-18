package pl.nobleprog.advanced.day4.c1concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.locks.ReentrantLock;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        // schedulers

        // ThreadLocal class
        threadLocalDemo();
        // CyclicBarier class

        // ReentrantLock

        // SynchronizedQueue

        // threadLocalDemo();

        // synchronizedQueue();
    }

    public static void threadLocalDemo() {
        ExecutorService service = Executors.newFixedThreadPool(2);
        ThreadLocal<Integer> counter = ThreadLocal.withInitial(() -> -1);
        counter.set(0);
        service.execute(() -> {
            for (int i = 0; i < 5; i++) {
                counter.set(5);
                System.out.println("Task 1 " + Thread.currentThread().getId() + " threadLocal: " + counter.get());
            }
        });
        service.execute(() -> {
            for (int i = 0; i < 5; i++) {
                counter.set(20);
                System.out.println("Task 2 " + Thread.currentThread().getId() + " threadLocal: " + counter.get());
            }
        });
        service.execute(() -> {
            counter.set(11);
            for (int i = 0; i < 5; i++) {
                System.out.println("Task 3 " + Thread.currentThread().getId() + " threadLocal: " + counter.get());
            }
        });
        service.shutdown();
    }


    public static void reentrantLockDemo() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Counter counter = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                while (!lock.tryLock()) {
                    System.out.println("Doing something in Thread1, cant get lock!");
                }
                counter.inc();
                System.out.println("Thread1");
                lock.unlock();
                try {
                    Thread.sleep((long) (Math.random() * 10));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                while (!lock.tryLock()) {
                    System.out.println("Doing something in Thread2, cant get lock!");
                }
                counter.inc();
                lock.unlock();
                try {
                    Thread.sleep((long) (Math.random() * 10));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread2");

            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.getValue());
    }

    public static void synchronizedQueue(){
        Random random = new Random();
        SynchronousQueue<Long> q = new SynchronousQueue<>(true);
        ExecutorService service = Executors.newFixedThreadPool(2);

        service.execute(() -> {
            for(int i = 0; i < 100; i++){
                q.offer(random.nextLong(100));
                try {
                    Thread.sleep(random.nextInt(10));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        service.execute(() -> {
            for(int i = 0; i < 100; i++){
                try {
                    System.out.println(q.take());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        service.shutdown();
    }
}

class Counter {
    private long value;

    public void inc() {
        value++;
    }

    public long getValue() {
        return value;
    }
}

class SynchronizedCounter {
    private long value;

    public synchronized void inc() {
        value++;
    }

    public synchronized long getValue() {
        return value;
    }
}


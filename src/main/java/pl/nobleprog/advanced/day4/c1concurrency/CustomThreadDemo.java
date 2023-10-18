package pl.nobleprog.advanced.day4.c1concurrency;

public class CustomThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        CustomThread thread = new CustomThread("Hello");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
        System.out.println("After thread start...");
        System.out.println(Thread.currentThread().getName());
        System.out.println("Thread ended");
    }
}
/*
    Napisz wlasna klase Thread z parametrem typu int (counter)
    w metodzie run wyswietl komunikat "hello" tyle razy ile wynosi counter
 */
package pl.nobleprog.advanced.day4.c1concurrency;

public class CustomRunnable implements Runnable{
    private String message;

    public CustomRunnable(String message) {
        this.message = message;

    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for(int i = 0 ; i < 10; i++){
            System.out.println(message);
        }
    }
}

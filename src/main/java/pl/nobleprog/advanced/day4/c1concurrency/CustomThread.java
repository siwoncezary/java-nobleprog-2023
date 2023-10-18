package pl.nobleprog.advanced.day4.c1concurrency;

public class CustomThread extends Thread{
    private String message;

    public CustomThread(String message) {
        this.message = message;
        System.out.println(this.getState());
    }

    @Override
    public void run() {
        System.out.println(this.getState());
        int i = 10;
        while(--i>0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Sleep interrupted");
            }
            System.out.println("Thread working "+ this.getName());
            System.out.println(message);
        }
    }
}

package pl.nobleprog.advanced.day1.c2interface;

public interface Flyable {
    void takeoff();
    void land();

    default void stop(){
        land();
    }
}

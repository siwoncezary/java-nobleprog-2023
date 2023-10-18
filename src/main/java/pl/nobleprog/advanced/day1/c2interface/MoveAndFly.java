package pl.nobleprog.advanced.day1.c2interface;

public interface MoveAndFly extends Flyable, Moveable{
    @Override
    default void stop() {
        Flyable.super.stop();
    }
}

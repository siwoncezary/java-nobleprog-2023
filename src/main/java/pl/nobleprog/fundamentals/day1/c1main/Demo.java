package pl.nobleprog.fundamentals.day1.c1main;


public class Demo {
    public static void main(String[] args) {
        // main method

        // System.out.println() and System.out.print()

        // escape sequences: \n \t \b

        // terminal colors: "\033[0;94m", "\033[1;104m", "\033[0m"

        // javac and java

        System.out.println("\33[0;96m\33[1;102mHello");

        System.out.println("\u001B[1;45m" + "Hello");

        System.out.println("\033[0m");

        System.out.println("\u0061\u263a");
    }
}

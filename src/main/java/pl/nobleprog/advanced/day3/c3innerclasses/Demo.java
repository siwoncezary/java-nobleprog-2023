package pl.nobleprog.advanced.day3.c3innerclasses;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Demo {
    private int status = 4;

    public static void main(String[] args) {
        // Java main principle - class in Java is first citizen, may occur in all possible code places: file, class, method

        // static inner classes - nested classes

        NestedDemoClass nestedDemoClass = new NestedDemoClass(0);
        nestedDemoClass.inc();
        System.out.println(nestedDemoClass.getCounter());
        System.out.println(nestedDemoClass.counter); // outer class have access to private members of his nested class!
        System.out.println();

        // inner classes - non-static classes

        Chicken chicken = new Chicken();
        Chicken.Egg egg1 = chicken.getEgg();
        Chicken.Egg egg2 = chicken.new Egg();   // only instance of outer class can instantiate object of inner class!

        // local classes - may occur in methods

        class Point {
            double x;
            double y;

            public Point(double x, double y) {
                this.x = x;
                this.y = y;
            }
        }

        List<Point> points = IntStream
                .range(0, 100)
                .mapToObj(i -> new Point(Math.random()*100, Math.random()*100))
                .toList();

        // anonymous class - class without name, which implements interface or abstract class, and instantiate object of this class

        TreeSet<String> set = new TreeSet<>(
                new Comparator<String>() {                      // anonymous class implementing Comparator interface
                    @Override
                    public int compare(String o1, String o2) {
                        return Integer.compare(o1.length(), o2.length());
                    }
                }
        );
    }

    public static class NestedDemoClass {
        private int counter;

        public NestedDemoClass(int counter) {
            this.counter = counter;
        }

        public void inc() {
            counter++;
        }

        public int getCounter() {
            return counter;
        }

        public void setOuter(Demo outer) {
            outer.status = 2;           // nested class have access to private members of outer class!
        }
    }
}

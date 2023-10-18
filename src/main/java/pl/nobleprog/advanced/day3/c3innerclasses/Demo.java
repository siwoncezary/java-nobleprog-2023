package pl.nobleprog.advanced.day3.c3innerclasses;

import pl.nobleprog.advanced.day1.c1abstraction.task.AbstractMessageSender;
import pl.nobleprog.advanced.day1.c1abstraction.task.Message;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.IntStream;

class Demo {
    public static void main(String[] args) {
        // Java main principle - class in Java is first citizen, may occur in all possible code places: file, class, method

        // static inner classes - nested classes
        Email email = Email.builder()
                .to("ewa@noble.pl")
                .content("Hello")
                .build();
        // inner classes - non-static classes
        Chicken chicken = new Chicken();
        Chicken.Egg egg = chicken.new Egg();
        System.out.println(chicken.getEggCounter());
        egg = chicken.getEgg();
        System.out.println(chicken.getEggCounter());
        // local classes - may occur in methods
        class Point {
            private double x;
            private double y;

            public Point(double x, double y) {
                this.x = x;
                this.y = y;
            }
        }

        List<Point> points = IntStream
                .range(0, 100)
                .mapToObj(i -> new Point(Math.random()*100, Math.random()* 100))
                .peek(p -> System.out.println(p.x))
                .toList();

        // anonymous class - class without name, which implements interface or abstract class, and instantiate object of this class
        String phoneNumber = "1223334";
        Message sms = new Message("hello") {
            private String phone = phoneNumber;
            @Override
            public void send(AbstractMessageSender sender) {
                System.out.println("Send SMS");
                method();
            }

            private void method(){
                System.out.println("Method");
            }
        };

        Function<String, Integer> parse = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        };
        parse = new Parser();

        Function<String, Integer> lambdaParser = s -> Integer.parseInt(s);
        Function<String, Integer> lambdaParserReference = Integer::parseInt;
        List<String> names = new ArrayList<>(){
            {
                add("Karol");
                add("Ewa");
                add("Adam");
            }
        };
        ArrayList<String> list = new ArrayList<>(List.of("Ewa", "Karol", "Adam"));
        System.out.println(names);
        System.out.println(list);

        // wstaw jako klase anonimowa komparator w parametrze konstruktora
        // sortowanie wzgledem dlugosci lancucha

        TreeSet<String> set = new TreeSet<>(Comparator.comparingInt(s -> s.length()));
        set.add("Adam");
        set.add("Ewa");
        set.add("Karol");
        System.out.println(set);
    }
}

class Parser implements Function<String,Integer>{

    @Override
    public Integer apply(String s) {
        return Integer.parseInt(s);
    }
}

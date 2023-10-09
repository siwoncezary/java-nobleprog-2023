package pl.nobleprog.advanced.day2.c3strings.task;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test {
    static Random random = new Random();
    public static void test(){
        String data = "";
        IntStream
                .range(1, 1_000_000).mapToObj(i -> ("a" + random.nextInt('z' - 'a')).repeat(random.nextInt(1000)))
                .collect(Collectors.joining());
        long start = System.nanoTime();
        StringTask.joinWithIdent(data);
        long time = System.nanoTime() - start;
        if (data.lines().allMatch(line -> line.startsWith("     "))){
            System.out.println("Test passed.");
        } else{
            System.out.println("Test failed!");
        }
        if(time < 1000_000){
            System.out.println("Time test passed.");
        } else {
            System.out.println("Time test failed!");
        }

    }
}

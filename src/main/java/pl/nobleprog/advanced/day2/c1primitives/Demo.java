package pl.nobleprog.advanced.day2.c1primitives;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

class Value{
    int v;

    public Value(int v) {
        this.v = v;
    }
}

public class Demo {
    public static void main(String[] args) {
        // why use primitive types?

        // simple memory model, simpler coding

        // better performance

        // variables created on stack not heap

        // cant be null
        int size = 1_000_000;
        long time = System.nanoTime();
        sumOfObjects(IntStream.range(0, size).mapToObj(Value::new).toList());
        System.out.printf("Time of summing objects:    %10.2f ms\n", (System.nanoTime() - time)/1000_000.0);
        time = System.nanoTime();
        sumOfPrimitives(IntStream.range(0, size).toArray());
        System.out.printf("Time of summing primitives: %10.2f ms", (System.nanoTime() - time)/1000_000.0);
    }


    static public void sumOfObjects(List<Value> list){
        int sum = 0;
        for(Value v:list){
            sum += v.v;
        }
    }

    static public void sumOfPrimitives(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
    }
}

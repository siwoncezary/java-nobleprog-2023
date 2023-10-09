package pl.nobleprog.advanced.day2.c1primitives;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

class Value{
    final int v;

    public Value(int v) {
        this.v = v;
    }
}

public class Demo {
    public static void main(String[] args) {
        // why use primitive types?

        //  - simple memory model, simpler coding

        // - better performance

        // - variables created on stack not heap

        // - cant be null

        // performance examples
        int size = 1_000_000;
        long time = System.nanoTime();

        // sum of boxed int
        sumOfObjects(IntStream.range(0, size).mapToObj(Integer::valueOf).toList());
        System.out.printf("%-32s %10.2f ms\n","Time of summing objects:" ,(System.nanoTime() - time)/1000_000.0);

        //sum of primitives
        time = System.nanoTime();
        sumOfPrimitives(IntStream.range(0, size).toArray());
        System.out.printf("%-32s %10.2f ms\n", "Time of summing primitives:", (System.nanoTime() - time)/1000_000.0);

        //sum of custom wrapper of int
        time = System.nanoTime();
        sumOfCustomWrapper(IntStream.range(0, size).mapToObj(Value::new).toList());
        System.out.printf("%-32s %10.2f ms\n","Time of summing custom wrapper:", (System.nanoTime() - time)/1000_000.0);
    }


    static public void sumOfObjects(List<Integer> list){
        Integer sum = 0;
        for(Integer v:list){
            sum += v;
        }
    }

    static public void sumOfPrimitives(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
    }

    static  public void sumOfCustomWrapper(List<Value> list){
        int sum = 0;
        for(Value v:list){
            sum += v.v;
        }
    }

}

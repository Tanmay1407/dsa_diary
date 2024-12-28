package core.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Stateless Operations: Are only concerned about the current element of object/entity
Stateful Operations: Are concerned about the complete state of object/entity

Parallel Streams:
    - a type of stream that enables parallel processing of elements
    - allowing multiple threads to process parts of the stream simultaneously
    - this can significantly improve the performance for large datasets
    - workload is distributed across multiple threads
    - are most effective for CPU-Intensive & large datasets where tasks are INDEPENDENT
    - they can be overhead for simple tasks or small datasets
 */
public class ParallelStreams {
    public static void main(String[] args) {
        List<Integer> numbers = Stream.iterate(1,x -> x + 1).limit(20000).collect(Collectors.toList());
        long startTime = System.currentTimeMillis();
        List<Long> factorialList = numbers.stream().map(ParallelStreams::factorial).collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken to calculate factorials using sequential stream: "+(endTime-startTime)+"ms");

        startTime = System.currentTimeMillis();
        factorialList = numbers.parallelStream().map(ParallelStreams::factorial).collect(Collectors.toList());
        endTime = System.currentTimeMillis();
        System.out.println("Time taken to calculate factorials using parallel stream: "+(endTime-startTime)+"ms");
    }

    private static long factorial(int n){
        long fact = 1;
        for(int i = 2; i <= n; i++) fact *= i;
        return fact;
    }
}

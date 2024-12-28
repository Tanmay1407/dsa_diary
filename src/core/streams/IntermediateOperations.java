package core.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 - Intermediate operations transform a stream into another stream
 - They are Lazy, means they don't execute until a terminal operation is invoked (e.g. collect,count)
*/

public class IntermediateOperations {
    public static void main(String[] args) {
        String[] members = {"Ram","Shyam","Rohan","Gita","Ram"};
        Stream<String> memberStream = Arrays.stream(members);

        //Filter:
        System.out.println(memberStream.filter(x -> x.toLowerCase().startsWith("r")).collect(Collectors.toList()));

        //Map:
        memberStream = Arrays.stream(members);
        System.out.println(memberStream.map(x -> x.toUpperCase()).collect(Collectors.toList()));

        //Sorted:
        memberStream = Arrays.stream(members);
        System.out.println(memberStream.sorted().collect(Collectors.toList()));

        //Distinct:
        memberStream = Arrays.stream(members);
        System.out.println(memberStream.filter(x -> x.startsWith("R")).distinct().count());

        // Limit & Skip
        Stream<Integer> myStream = Stream.iterate(1,x -> x + 1);
        System.out.println(myStream.skip(10).limit(6).collect(Collectors.toList()));

        //Peek
        List<Integer> numbers = Stream.iterate(1,x -> x + 1).limit(10).collect(Collectors.toList());
        numbers.stream().map(x -> x*x).peek(System.out::println).collect(Collectors.toList());

        //FlatMap
        // - handles streams of collections, lists or arrays where each element is itself a collection
        // - Flatten nested structures (e.g. lists with a list) so that they can be processed as a single sequence
        // - Transforms & Flattens the elements at the same time
        List<List<String>> fruits = Arrays.asList(
                Arrays.asList("Mango","Apple"),
                Arrays.asList("Banana","Kiwi")
        );
        System.out.println(fruits.stream().flatMap(x -> x.stream()).map(String::toUpperCase).collect(Collectors.toList()));

    }
}

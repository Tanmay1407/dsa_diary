package core.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreams {
    public static void main(String[] args) {
    // Method Reference: use method without invoking & in-place of lambda expression
        List<String> names = Arrays.asList("Ram","Shyam","Gopal");
        names.forEach(System.out::println);
    // Constructor Reference:
        List<Person> members = names.stream().map(Person::new).collect(Collectors.toList());
        members.forEach(p -> System.out.println("Member Name: "+p.name));

        //Creating Streams:
        //1. Stream from List
        List<Integer> nums = Arrays.asList(1,2,3,4,5);
        Stream<Integer> strm1 = nums.stream();
        //2. From Array
        Integer[] arr = {1,2,3,4,5};
        Stream<Integer> strm2 = Arrays.stream(arr);
        //3. Using Stream.of()
        Stream<String> strm3 = Stream.of("a","b","c");
        //4. Infinite Stream
        Stream<Integer> generate = Stream.generate(() -> 1);
        System.out.println(generate.limit(20).collect(Collectors.toList()));
        // OR
        List<Integer> myList = Stream.iterate(1,x -> x + 1).limit(10).collect(Collectors.toList());
        System.out.println(myList);





    }
}

class Person {
    String name;
    Person(String name){
        this.name = name;
    }
}

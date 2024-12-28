package core.streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamCollectors {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ram","Shyam","Geeta","Ram");
        //1. Collecting to List
        List<String> upperCaseNames = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(upperCaseNames);

        //2. Collecting to Set
        Set<String> uniqueNames = names.stream().collect(Collectors.toSet());
        System.out.println(uniqueNames);

        //3. Collecting to Specific Collection
        ArrayDeque<String> arrayDeque = names.stream().collect(Collectors.toCollection(()-> new ArrayDeque<>()));
        System.out.println(arrayDeque);

        //4. Concatenating
        String joinedNames = names.stream().collect(Collectors.joining(", "));
        System.out.println(joinedNames);

        //5. Summarizing Data
        List<Integer> nums = Arrays.asList(4,3,2,4,5,6,7,8,9,6,5,3,2,3,4,5,6,8);
        IntSummaryStatistics stats = nums.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println("Count: "+stats.getCount());
        System.out.println("Sum: "+stats.getSum());
        System.out.println("Min: "+stats.getMin());
        System.out.println("Max: "+stats.getMax());
        System.out.println("Average: "+stats.getAverage());

        //6.Grouping Elements:
        System.out.println(nums.stream().collect(Collectors.groupingBy(x -> x%2 == 0 ? "Even" : "Odd")));
        System.out.println(nums.stream().collect(Collectors.groupingBy(x -> x%2 == 0 ? "Even" : "Odd", Collectors.counting())));
        TreeMap<String,Long> evenOddCount  = nums.stream().collect(Collectors.groupingBy(x -> x%2 == 0 ? "Even" : "Odd",TreeMap::new,Collectors.counting()));
        System.out.println(evenOddCount);

        //7. Partitioning
        System.out.println(nums.stream().collect(Collectors.partitioningBy(x -> x > 5)));

        //8.Mapping & Collecting
        List<String> lowerCaseNames = names.stream().collect(Collectors.mapping(String::toLowerCase,Collectors.toList()));    }
}

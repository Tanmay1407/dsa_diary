package core.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TerminalOperations {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ram","Shyam","Rio","Pio");

        //Filter & Collect
        System.out.println(names.stream().filter(x -> x.toLowerCase().startsWith("r")).collect(Collectors.toList()));

        //Sorting
        List<Integer> nums = Arrays.asList(4,1,2,7,5,9);
        System.out.println(nums.stream().map(x -> x * x).sorted().collect(Collectors.toList()));

        //Reduce
        System.out.println(nums.stream().reduce(Integer::sum).get());

        //Count
        String str = "Hello World";
        System.out.println(str.chars().filter(x -> x == 'l').count());

        //Min/Max
        System.out.println("Min: "+nums.stream().min(Comparator.naturalOrder()).get());
        System.out.println("Max: "+nums.stream().max(Comparator.naturalOrder()).get());

        //FindFirst, FindAny
        System.out.println("First: "+nums.stream().findFirst().get());
        System.out.println("FindAny: "+nums.stream().findAny().get());

        //forEach / forEachOrdered : for parallel streams
        nums.stream().forEach(System.out::println);


    }
}

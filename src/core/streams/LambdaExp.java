package core.streams;

import java.util.function.*;

public class LambdaExp {
    public static void main(String[] args) {

        //Providing a method definition to operate method of MathOperation  interface
        //using Lambda expression (no need to create a class to implement the interface)

        //Here we are using reference of interface to hold lambda expression
        //i.e. a function is treated as a variable which is termed as Function Programming
        MathOperation addOperation = (a,b) -> a+b;

        //Similarly
        MathOperation subtractOperation = (a,b) -> a-b;

        System.out.println(addOperation.operate(10,20));
        System.out.println(subtractOperation.operate(100,50));

        //Predicate -> Functional Interface (Boolean valued function)
        Predicate<Integer> isEven = x -> x%2 == 0;
        System.out.println("is Even: "+isEven.test(4));

        Predicate<Integer> isGreaterThanHundred = x -> x > 100;

        //Combining two predicates
        Predicate<Integer> evenAndGreaterThanHundred = isEven.and(isGreaterThanHundred);
        System.out.println(evenAndGreaterThanHundred.test(200));
        System.out.println(evenAndGreaterThanHundred.test(20));

        //Function - custom work
        Function<Integer,Integer> doubleIt = x -> x * 2;
        System.out.println("Double IT: 100: "+doubleIt.apply(100));

        //Consumer - consumes the input without returning anything
        Consumer<String> logger = x -> System.out.println("-- "+x);
        logger.accept("This is my log");

        //Supplier returns values without any input
        Supplier<Integer> getHello = () -> 110;
        System.out.println(getHello.get());

        //Combined Example:
        logger.accept(evenAndGreaterThanHundred.test(doubleIt.apply(getHello.get()))? "YES" : "NO");

        //BiFunction - takes two inputs
        //Similarly: BiConsumer,BiPredicate
        BiFunction<Integer,Integer,Integer>  multiply = (x,y) -> x*y;

        //UnaryOperator - takes single input (output type same as input type)
        UnaryOperator<Integer> square = x -> x*x;
        //BinaryOperator - takes two inputs (output type same as input type)
        BinaryOperator<String> combinedString = (s1,s2) ->( s1+s2);

        System.out.println("Square 5: "+square.apply(5) );
        System.out.println("Combine: ab ,cd: "+combinedString.apply("ab","cd"));

    }
}

//Function Interface - contains only one abstract method (there can be other default methods)
@FunctionalInterface
interface  MathOperation {
    int operate(int a, int b);
}

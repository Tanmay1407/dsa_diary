package recursion;
//Notes:
//Direct Recursion: a function calls itself fun1(){...fun1()...}
//Indirect Recursion: a function calls another function & that function calls back the first function
//                    fun1(){...fun2(){...fun1()...}...}

public class Main {
    public static void main(String[] args) {
        System.out.println("This is recursion!");
        System.out.println("log16 base 2 : "+ logBaseTwo(16));
        System.out.println("log4 base 2 : "+ logBaseTwo(4));
        System.out.println("log13 base 2 : "+ logBaseTwo(13));

        printBinary(5);
        System.out.println();
        printBinary(9);
        System.out.println();
        printNto1(5);
        System.out.println();
        System.out.println("Factorial of 5: "+factorial(5,1));
        System.out.println("Fibonacci Sum for 10 nums: "+fiboSum(10));

    }

    static double logBaseTwo(int n){
        if(n == 1) return 0;
        else return 1 + logBaseTwo(n/2);
    }

    static void printBinary(int n){
        if(n == 0) return;
        printBinary(n/2);
        System.out.print(n%2);
    }

    static void printNto1(int n){
        if(n == 0) return;
        System.out.print(n+" ");
        printNto1(n-1);
    }

    static int factorial(int n, int k){
        if(n == 0 || n == 1)
            return k;
        return factorial(n-1,k*n);
    }

    // 0,1,1,2,3,4,7...
    static int fiboSum(int n){
        if(n <= 1) return n;
        return fiboSum(n-1)+fiboSum(n-2);
    }
}



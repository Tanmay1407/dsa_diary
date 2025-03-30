package algorithms;

public class PrimeFactors {
    public static void main(String[] args) {
        int[] nums = {200,25,17,300};
        for(int n : nums){
            System.out.print("Prime Factors of "+n+" are: ");
            printAllPrimeFactors(n);
            System.out.print(" -> "+distinctPrimeFactors(n)+" distinct factors");
            System.out.println();
        }
    }

    private static void printAllPrimeFactors(int num){
        while(num % 2 == 0){
            System.out.print(2+" ");
            num /= 2;
        }
        //Check the odd factors
        for(int i = 3; i <= Math.sqrt(num); i+=2){
            while(num % i == 0){
                System.out.print(i+" ");
                num /= i;
            }
        }
        //If the num is still greater than 2 then it itself is a Prime Number
        if(num > 2) System.out.print(num+" ");
    }

    private static int distinctPrimeFactors(int num){
        int distinctFactors = 0;
        while(num%2 == 0){
            distinctFactors = 1;
            num /= 2;
        }
        for(int i = 3; i < Math.sqrt(num); i++){
            int factor = 0;
            while(num % i == 0){
                factor = 1;
                num /= i;
            }
            distinctFactors += factor;
        }
        if(num > 2)  distinctFactors++;
        return distinctFactors;
    }
}

package algorithms;

public class XPowerOfN {
    public static void main(String[] args) {
        int[] nums = {12,-4,16,8,3,4,2,3};
        for(int n : nums){
            System.out.println("For Num: "+n+" Square: "+pow(n,2));
        }
        for(int n : nums){
            System.out.println("For Num: "+n+" Cube: "+pow(n,3));
        }
    }

    //Modular Exponentiation using Binary Exponentiation (also known as exponentiation by squaring)
    private static long pow(int x, int n){
        long result = 1;
        for(; n > 0; n >>= 1){
            if((n&1) == 1){
                result = result * x;
            }
            x = x * x;
        }
        return result;
    }
}

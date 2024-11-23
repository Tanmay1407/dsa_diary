package sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {6,5,4,3,2,1};
        bubbleSort(arr);
        for(int n : arr) System.out.print(n+" ");
    }

    public static void bubbleSort(int[] nums){
        boolean flag = true; // To avoid extra passes
        for(int i = 0; i < nums.length; i++){
            flag = true;
            for(int j = 0; j < nums.length - i -1; j++){
                if(nums[j] > nums[j+1]){
                    int swap = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = swap;
                    flag = false;
                }
            }
            if(flag) break;
        }
    }
}

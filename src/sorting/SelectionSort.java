package sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {6,5,4,4,2,1,3,2,1};
        selectionSort(arr);
        for(int n : arr) System.out.print(n+" ");
    }
// Find the best element suitable for the current position/index
    public static void selectionSort(int[] nums){
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int min = i;
            for(int j = i+1; j < n; j++){
                if(nums[min] > nums[j]) min = j;
            }
            int swap = nums[i];
            nums[i] = nums[min];
            nums[min] = swap;
        }
    }
}



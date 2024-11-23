package sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {6,5,4,4,2,1,3,2,1};
        insertionSort(arr);
        for(int n : arr) System.out.print(n+" ");
    }
    // Sort one-at-a-time
    public static void insertionSort(int[] nums){
        int n = nums.length;
        for(int i = 1; i < n; i++){
            int key = nums[i];
            int j = i-1;
            while(j >= 0 && nums[j] > key){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = key;
        }
    }
}

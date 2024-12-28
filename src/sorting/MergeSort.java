package sorting;

/*
Time Complexity:
Best: O(n*logn) : when already sorted
Avg: O(n*logn) : when jumbled in random order
Worst:  O(n*logn) : sorted in dec order (if sorting in ascending order)

Space Complexity: O(n) : variable required for swaping
*/
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {-6,5,4,3,2,1,9,-5};
        mergeSort(0,nums.length-1,nums);
        for(int n : nums) System.out.print(n+" ");
    }

    public static  void mergeSort(int begin, int end, int[] nums){
        if(begin < end){
            int mid = begin + (end-begin)/2;
            mergeSort(begin,mid,nums);
            mergeSort(mid+1,end,nums);
            merge(begin,mid,end,nums);
        }
    }

    public static  void merge(int begin, int mid, int end, int[] nums){
        int i = begin, j = mid+1, k = 0;
        int[] tempNums = new int[end-begin+1];
        while(i <= mid && j <= end){
            if(nums[i] <= nums[j]) {
                tempNums[k++] = nums[i++];
            }else{
                tempNums[k++] = nums[j++];
            }
        }
        while(i <= mid) tempNums[k++] = nums[i++];
        while(j <= end) tempNums[k++] = nums[j++];

        System.arraycopy(tempNums,0,nums,begin,k);
    }
}

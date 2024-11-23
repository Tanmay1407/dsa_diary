package sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {6,5,4,4,2,1,3,2,1,0,9};
        mergeSort(arr,0, arr.length-1);
        printArr(arr);
    }

    public static void mergeSort(int[] nums,int begin,int end){
        if(begin < end){
            int mid = begin + (end-begin)/2;
            mergeSort(nums,begin,mid);
            mergeSort(nums,mid+1,end);
            merge(nums,begin,mid,end);
        }
    }

    public static void merge(int[] nums, int begin, int mid, int end){
        int[] merged = new int[end - begin + 1];
        int k = 0;
        int i = begin, j = mid+1;
        while (i <= mid && j <= end){
            if(nums[i] < nums[j]) merged[k++] = nums[i++];
            else merged[k++] = nums[j++];
        }
        while (i <= mid) merged[k++] = nums[i++];
        while (j <= end) merged[k++] = nums[j++];
        System.arraycopy(merged, 0, nums, begin, merged.length);
    }

    public static void printArr(int nums[]){
        System.out.println();
        for(int n : nums) System.out.print(n+" ");
    }
}

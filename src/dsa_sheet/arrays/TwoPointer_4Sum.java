package dsa_sheet.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointer_4Sum {
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> ans = fourSum(nums,target);
        System.out.println(ans);
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < n; j++){
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int p = j+1;
                int q = n-1;
                while(p < q){
                    long sum = (long)nums[i]+(long)nums[j]+(long)nums[p]+(long)nums[q];
                    if(sum > target){
                        q--;
                    }else if(sum < target){
                        p++;
                    }else{
                        ans.add(Arrays.asList(nums[i],nums[j],nums[p],nums[q]));
                        p++;q--;
                        while(p < q && nums[p] == nums[p-1]) p++;
                        while(p < q && nums[q] == nums[q+1]) q--;
                    }
                }
            }
        }
        return ans;
    }
}

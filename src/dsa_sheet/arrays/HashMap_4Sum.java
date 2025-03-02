package dsa_sheet.arrays;

import java.util.*;

//https://leetcode.com/problems/4sum/description/

public class HashMap_4Sum {
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> ans = fourSum(nums,target);
        System.out.println(ans);
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<Long> set = new HashSet<>();
        Set<List<Integer>> ansSet = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                set.clear();
                for (int k = j + 1; k < n; k++) {
                    long remains = (long)target - (long)nums[i] - (long)nums[j] - (long)nums[k];
                    if (set.contains(remains)) {
                        List<Integer> quadruplet = Arrays.asList(nums[i], nums[j], nums[k], (int)remains);
                        Collections.sort(quadruplet);
                        ansSet.add(quadruplet);
                    } else {
                        set.add((long)nums[k]);
                    }
                }

            }
        }
        return new ArrayList(ansSet);
    }
}



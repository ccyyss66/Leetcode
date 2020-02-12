package main.java.双指针.leetcode16;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length<3) return 0;
        Arrays.sort(nums);
        int len = nums.length;
        int closest = nums[0]+nums[1]+nums[2];
        for (int i=0;i<len-2;i++){
            int left =i+1,right = len-1;
            while (left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if (Math.abs(sum-target)<Math.abs(closest-target)) closest = sum;
                if (sum<target) left++;
                else right--;
            }
        }
        return closest;
    }
}

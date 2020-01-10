package main.java.leetcode53;

public class Solution {
    public int maxSubArray(int[] nums) {
        int max = 0;
        int first = nums[0];
        for (int i=1;i<nums.length;i++){
          if (nums[i-1]>0) nums[i] += nums[i-1];
            max = Math.max(max,nums[i]);
        }
        return max;
    }
}

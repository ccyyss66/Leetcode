package main.java.二分查找.leetcode300;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        if (len<=0) return 0;
        dp[0] = 1;
        int max = 0;
        for (int i=1;i<len;i++){
            for (int j=0;j<i;j++){
                if (nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
                max =Math.max(dp[i],max);
            }
        }
        return max;
    }

    /**
     * 二分+dp 改变dp内的含义
     * @param nums
     * @return
     */
    public int lengthOfLIS1(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if(res == i) res++;
        }
        return res;
    }
}

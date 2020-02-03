package main.java.模拟面试.第一次面试;

import java.util.Arrays;

public class Solution2 {
//    int number = 0;
//    public int combinationSum4(int[] nums, int target) {
//        Arrays.sort(nums);
//        dfs(nums,target,0);
//        return number;
//    }
//    public void dfs(int[] nums,int target,int now){
//        if (now == target) number++;
//        else {
//            for (int i=0;i<nums.length;i++){
//                if (now+nums[i]<=target)
//                dfs(nums,target,now+nums[i]);
//                else break;
//            }
//        }
//    }
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i=1;i<=target;i++){
            for(int j=0;j<nums.length;j++){
                if (i>=nums[j]) dp[i] = dp[i]+dp[i-nums[j]];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] s ={1,2,3};
        Solution2 solution = new Solution2();
        solution.combinationSum4(s,4);
    }
}

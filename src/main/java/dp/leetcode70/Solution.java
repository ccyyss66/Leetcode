package main.java.dp.leetcode70;

public class Solution {
//    static int  nums = 0;
//    public int climbStairs(int n) {
//        climb(n,nums);
//        return nums;
//    }
//    public  void climb(int n,int nums){
//        if (n==0) { nums++; return;}
//        climb(n-1, nums);
//        climb(n-2, nums);
//    }
    public int clinbStairs(int n){
        int[] dp = new int[n+1];
        if (n == 1) return 1;
        if (n == 2) return 2;
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}

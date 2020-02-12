package main.java.dp.leetcode264;

public class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int dp_2=0,dp_3=0,dp_5=0;
        int min = 1;
        for (int i=1;i<n;i++){
            min = Math.min(Math.min(dp[dp_2]*2,dp[dp_3]*3),dp[dp_5]*5);
            if (min == dp[dp_2]*2) dp_2++;
            if (min == dp[dp_3]*3) dp_3++;
            if (min == dp[dp_5]*5) dp_5++;
            dp[i] = min;
         }
        return dp[n-1];
    }
}

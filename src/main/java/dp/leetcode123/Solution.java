package main.java.dp.leetcode123;

public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len<=0) return 0;
        int max1=0,max2=0,max;
        int[] dp = new int[len+1];
        dp[0] = 0;
        int minPrice = prices[0];
        for (int i=1;i<len;i++){
            if (prices[i]<minPrice) minPrice = prices[i];

        }
        return 0;
    }
}

package main.java.dp.leetcode121;

public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int length = prices.length;
        int minbuy = prices[0];
        for (int i=1;i<prices.length;i++){
            if (prices[i] - minbuy <0) minbuy = prices[i];
            maxProfit = Math.max(maxProfit,prices[i] - minbuy);
        }
        return maxProfit;
    }
}

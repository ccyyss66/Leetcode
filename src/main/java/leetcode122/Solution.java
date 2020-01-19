package main.java.leetcode122;

public class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int len = prices.length;
        if (len ==0) return 0;
        int minPrice = prices[0];
        for (int i=1;i<len;i++){
            if (prices[i]<prices[i-1]) {
                max +=prices[i-1] - minPrice;
                minPrice = prices[i];
            }
        }
        max +=prices[len-1] -minPrice;
        return max;
    }
}

package main.java.dp.leetcode322;

import java.util.Arrays;

public class Solution {
    public int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        if (dp[amount] == amount + 1) return -1;
        else return dp[amount];
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i=0;i<coins.length;i++){
            for (int j=coins[i];j<=amount;j++){
                if (dp[j-coins[i]] != amount +1){
                    dp[j] = Math.min(dp[j-coins[i]]+1,dp[j]);
                }
            }
        }
        return (dp[amount] == amount+1)?-1:dp[amount];
    }
}

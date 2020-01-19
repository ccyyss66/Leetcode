package main.java.dp.leetcode72;

public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        dp[0][0] = 0;
        for (int i=1;i<=word1.length();i++)
            dp[i][0] = i;
        for (int j=1;j<=word2.length();j++)
            dp[0][j] = j;
        for (int i=1;i<=len2;i++){
            for (int j=1;j<=len1;j++){
                if (word1.charAt(j-1) == word2.charAt(i-1)){
                    dp[j][i] = dp[j-1][i-1];
                }
                else
                    dp[j][i] = Math.min(dp[j-1][i-1],Math.min(dp[j-1][i],dp[j][i-1]))+1;
            }
        }
        return dp[len1][len2];
    }
}

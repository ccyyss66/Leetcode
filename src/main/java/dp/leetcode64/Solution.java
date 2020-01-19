package main.java.dp.leetcode64;

public class Solution {
    public int minPathSum(int[][] grid) {
        int len = grid.length;
        if (len <=0) return 0;
        int width = grid[0].length;
        int[][] dp = new int[len][width];
        dp[0][0] = grid[0][0];
        for (int i=1;i<len;i++)
            dp[i][0] = dp[i-1][0] + grid[i][0];
        for (int i=1;i<width;i++)
            dp[0][i] = dp[0][i-1] + grid[0][i];
        for (int i=1;i<len;i++){
            for(int j =1;j<width;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[len-1][width-1];
    }
}

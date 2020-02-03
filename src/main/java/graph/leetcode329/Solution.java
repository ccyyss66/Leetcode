package main.java.graph.leetcode329;

public class Solution {
    private int len;
    private int width;
    private int max = 0;
    public int longestIncreasingPath(int[][] matrix) {
        int len = matrix.length;
        if (len==0) return 0;
        int width = matrix[0].length;
        int[][] dp = new int[len][width];
        this.len = len;
        this.width = width;
        for (int i =0;i<len;i++){
            for (int j=0;j<width;j++){
                if (dp[i][j]==0)
                    dfs(i,j,matrix,dp);
            }
        }
        return max;
    }
    private int dfs(int i,int j,int[][] matrix,int[][] dp){
        if (i<0 || j<0 || i>=len || j>= width) return 0;
        int k1=0,k2=0,k3=0,k4=0;
        if ( i+1<len){
            if (matrix[i][j]>matrix[i+1][j]){
            if (dp[i+1][j]==0) {
                 k1 = dfs(i + 1, j, matrix, dp);
            }
            else {
                 k1 =  dp[i+1][j];
            }
            }
            else k1=0;
        }
        if (i-1>=0){
            if (matrix[i][j]>matrix[i-1][j]) {
                if (dp[i - 1][j] == 0) {
                    k2 = dfs(i - 1, j, matrix, dp);
                } else {
                    k2 = dp[i - 1][j];
                }
            }
            else k2 = 0;
        }
        if (j-1>=0){
            if (matrix[i][j]>matrix[i][j-1]) {
                if (dp[i][j - 1] == 0) {
                    k3 = dfs(i, j - 1, matrix, dp);
                } else {
                    k3 = dp[i][j - 1];
                }
            }else k3 = 0;

        }
        if (j+1<width){
            if (matrix[i][j]>matrix[i][j+1]) {
                if (dp[i][j + 1] == 0) {
                    k4 = dfs(i, j + 1, matrix, dp);
                } else {
                    k4 = dp[i][j + 1];
                }
            }else k4 = 0;
        }
        dp[i][j] = Math.max(Math.max(k1,k2),Math.max(k3,k4))+1;
        max = Math.max(max,dp[i][j]);
        return dp[i][j];
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2}};
        Solution solution = new Solution();
        System.out.println(solution.longestIncreasingPath(nums));
    }
}

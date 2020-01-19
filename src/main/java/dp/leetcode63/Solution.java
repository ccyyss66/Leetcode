package main.java.dp.leetcode63;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int len = obstacleGrid.length;
        int width = obstacleGrid[0].length;
        boolean noobs = true;
        if (obstacleGrid[0][0] == 1) return 0;
        for (int i =0;i<len;i++){
            if (obstacleGrid[i][0] == 1) {
                noobs = false;
            }
            if (noobs){
                obstacleGrid[i][0] = 1;
            }else {
                obstacleGrid[i][0] = 0;
            }


        }
        noobs = true;
        for (int i =1;i<width;i++){
            if (obstacleGrid[0][i] == 1) {

                noobs = false;
            }
            if (noobs)
                obstacleGrid[0][i] = 1;
            else
                obstacleGrid[0][i] = 0;
        }
        for (int i=1;i<width;i++){
            for (int j=1;j<len;j++){
                if (obstacleGrid[j][i] == 1) obstacleGrid[j][i] = 0;
                else obstacleGrid[j][i] = obstacleGrid[j-1][i] + obstacleGrid[j][i-1];
            }
        }
        return obstacleGrid[len-1][width-1];
    }

    public static void main(String[] args) {
        int[][] x = {{0,0,0},{0,1,0},{0,0,0}};
        Solution solution = new Solution();
        solution.uniquePathsWithObstacles(x);
    }
}

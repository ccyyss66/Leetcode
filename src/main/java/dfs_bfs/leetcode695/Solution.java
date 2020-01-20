package main.java.dfs_bfs.leetcode695;

public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int length = grid.length;
        if (length<=0) return 0;
        int width = grid[0].length;
        int max =0;
        boolean[][] visited = new boolean[length][width];
        for (int i=0;i<length;i++){
            for (int j=0;j<width;j++){
                if (grid[i][j] == 1 && visited[i][j] == false){
                    max = Math.max(max,dfs(grid,visited,i,j,length,width));
                }
            }
        }
        return 0;
    }
    private int dfs(int[][] grid,boolean[][] visited,int i,int j,int length,int width){
        if (i<0 || i>=length || j<0 || j>=width )
            return 0;
        if (visited[i][j]==false && grid[i][j] ==1) {
            visited[i][j] = true;
            return 1+dfs(grid,visited,i-1,j,length,width)+dfs(grid,visited,i+1,j,length,width)+dfs(grid,visited,i,j-1,length,width)+dfs(grid,visited,i,j+1,length,width);
        }
        else return 0;

    }


    public static void main(String[] args) {
        Solution solution =new Solution();
        int[][] x ={{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        solution.maxAreaOfIsland(x);
    }
}

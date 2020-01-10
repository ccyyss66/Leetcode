package main.java.dfs_bfs.leetcode200;

class Solution {
    private void dfs(int i,int j,char[][] grid){
        if (i<grid.length && j < grid[0].length && i >=0 &&j >=0) {
            if (grid[i][j] == '1') {
                grid[i][j] = '0';
                dfs(i - 1,j,grid);
                dfs(i,j-1,grid);
                dfs(i + 1, j, grid);
                dfs(i, j + 1, grid);
            }

        }
    }
    public int numIslands(char[][] grid) {
        if (grid.length <=0) return 0;
        int length = grid.length;
        int width = grid[0].length;
        int nums =0;
        for (int i=0;i<length;i++){
            for (int j=0;j<width;j++){
                if (grid[i][j] == '1'){
                    nums ++;
                    dfs(i,j,grid);
                }
            }
        }
        return nums;
    }
}
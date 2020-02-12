package main.java.dfs_bfs.leetcode547;

public class Solution {
    public int findCircleNum(int[][] M) {
        if (M.length<=0) return 0;
        int num=0;
        int[] visited = new int[M.length];
        for (int i=0;i<M.length;i++){
            if (visited[i] == 0) {
                dfs(M,visited,i);
                num++;
            }
        }
        return num;
    }
    private void dfs(int[][] M,int[] visited,int i){
        visited[i] = 1;
        for (int j=0;j<M.length;j++){
            if (visited[j]==0 && M[i][j] == 1){
                dfs(M,visited,j);
            }
        }
    }
}

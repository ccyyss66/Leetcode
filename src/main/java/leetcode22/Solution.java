package main.java.leetcode22;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    /**
     * 动态规划
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {

        String s = "";
        List<List<String>> dp =new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add(""); dp.add(list);
        int l,r;
        for (int i=1;i<=n;i++){
            List<String> nowlist = new ArrayList<>();
            for ( l=0,r=i-1;l<i;l++,r--){
                for (int j=0;j<dp.get(l).size();j++){
                    for (int k=0;k<dp.get(r).size();k++){
                        nowlist.add("("+dp.get(l).get(j)+")"+dp.get(r).get(k));
                    }
                }
            }
            dp.add(nowlist);
        }

    return list;
    }

    /**
     * DFS
     * @param n
     * @return
     */
    public List<String> generateParenthesis1(int n){
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }

        dfs("", 0, 0, n, res);
        return res;
    }
    public void dfs(String cur,int left,int right,int n,List<String> res){
        if (left == n && right == n){
            res.add(cur);
            return;
        }
        if (left<right){
            return;
        }
        if (left<n){
            dfs(cur+"(",left+1,right,n,res);
        }
        if (right<n){
            dfs(cur+"}",left,right+1,n,res);
        }
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.generateParenthesis(2);
    }
}

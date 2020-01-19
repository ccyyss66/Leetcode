package main.java.leetcode120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] dp = new int[len];
        Arrays.fill(dp,Integer.MAX_VALUE);
        if (len<=0) return 0;
        int k=0,p=0;
        dp[0] = triangle.get(0).get(0);
        for (int i=1;i<len;i++){
            for (int j=0;j<i+1;j++){
                k = p;
                if (j==0 ) {
                    p = dp[j];
                    dp[j] = dp[j] + triangle.get(i).get(j);
                }
//                else if (j==len-1)
//                    dp[j] = dp[j-1] + triangle.get(i).get(j);
                else {
                    p = dp[j];
                    dp[j] = Math.min(k, dp[j]) + triangle.get(i).get(j);

                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i=0;i<len;i++){
            min = Math.min(dp[i],min);
        }
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        a.add(-1);
        List<Integer> b = new ArrayList<>();
        b.add(2);b.add(3);
        List<Integer> c = new ArrayList<>();
        c.add(1); c.add(-1); c.add(-3);
        List<Integer> d = new ArrayList<>();
        d.add(4);d.add(1);d.add(8);d.add(3);
        list.add(a);
        list.add(b);
        list.add(c);
//        list.add(d);
        Solution solution = new Solution();
        solution.minimumTotal(list);
    }
}

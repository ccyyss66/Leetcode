package main.java.leetcode54;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int length = matrix.length;
        if (length<=0) return list;
        int width = matrix[0].length;
        int nums = length * width;
        int ll=0,lr=length-1,rl=width-1;
        while (list.size()<nums){
            if (ll != lr && ll !=rl) {
                for (int i = ll; i < rl; i++)
                    list.add(matrix[ll][i]);
                for (int j = ll; j < lr; j++)
                    list.add(matrix[j][rl]);
                for (int i = rl; i > ll; i--)
                    list.add(matrix[lr][i]);
                for (int j = lr; j > ll; j--)
                    list.add(matrix[j][ll]);
            }
            if (ll == lr && ll !=rl){
                for (int i = ll; i <= rl; i++)
                    list.add(matrix[ll][i]);
            }
            if (ll == rl && ll !=lr){
                for (int j = ll; j <= lr; j++)
                    list.add(matrix[j][rl]);
            }
            if(ll==rl && ll==lr) list.add(matrix[ll][lr]);
            ll ++;
            lr--;
            rl--;
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] s={{1,2,3},{4,5,6}};
        Solution solution =new Solution();
        solution.spiralOrder(s);
    }
}

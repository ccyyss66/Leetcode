package main.java.leetcode85.用stack和dp;

import java.util.Arrays;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        int length = matrix.length;
        int width = matrix[0].length;
        if (length<=0) return 0;
        int[] left = new int[width];
        int[] right = new int[width];
        int[] height = new int[width];
        Arrays.fill(right,width);
        max = 0;
        for (int i=0;i<length;i++){
            int minleft=0,maxright=width;
            for (int j =0;j<width;j++){
                height[j] =  (matrix[i][j] == '1') ? ++height[j] : 0;
            }
            for (int j=0;j<width;j++){
                if (matrix[i][j] == '1' ){
                    left[j] = Math.max(left[j],minleft);
                }
                else {
                    left[j] = 0;
                    minleft = j + 1;
                }
            }
            for (int j =width - 1;j>=0;j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], maxright);
                } else {
                    right[j] = width;
                    maxright = j;
                }
            }
             for (int j=0;j<width;j++){
                 max = Math.max(max,height[j]*(right[j]-left[j]));
             }
        }
        return max;
    }

    public static void main(String[] args) {
        char[][] s ={{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        char[][] s1={{'0','1'}};
        Solution solution = new Solution();
        solution.maximalRectangle(s1);
        return;
    }
}

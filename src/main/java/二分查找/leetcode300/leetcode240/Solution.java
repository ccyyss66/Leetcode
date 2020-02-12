package main.java.二分查找.leetcode300.leetcode240;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix.length;
        if (len==0) return false;
        int width = matrix[0].length;
        if (width==0) return false;
        int pos = 0,right = width-1;
        while (pos<len && right>=0){
            if (matrix[pos][right]>target) right--;
            else if (matrix[pos][right]<target) pos++;
            else return true;
        }
        return false;
    }
}

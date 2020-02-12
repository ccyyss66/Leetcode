package main.java.二分查找.leetcode74;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix.length;
        if (len<=0) return false;
        int width = matrix[0].length;
        int left = 0,right = len-1;
        while (left<=right){
            int mid = (left+right)/2;
            if (target<matrix[mid][0]){
                right = mid-1;
            }
            else if (target>matrix[mid][0])
                left = mid+1;
            else return true;
        }
        int pos = left - 1;
        left = 0;
        right = width-1;
        while (left<=right){
                int mid = (left+right)/2;
                if (target<matrix[pos][mid]){
                    right = mid-1;
                }
                else if (target>matrix[pos][mid])
                    left = mid+1;
                else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int[][] m1 = new int[][]{{1}};
        Solution solution = new Solution();
        solution.searchMatrix(m1,0);
    }
}

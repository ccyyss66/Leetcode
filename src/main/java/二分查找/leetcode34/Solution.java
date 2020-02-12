package main.java.二分查找.leetcode34;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len<=0) return new int[]{-1,-1};
        int start=-1,end=-1;
        int left =0,right= len-1;
        while (left<=right){
            int mid = (left+right)/2;
            if (nums[mid]<target){
                left = mid+1;
            }
            else if (nums[mid]>target){
                right =mid-1;
            }
            else {
                start = end = mid;
                while (start>=0 && nums[start]==target) start--;
                while (end<len && nums[end]==target) end++;
                return new int[]{start+1,end-1};
            }
        }
        return new int[]{-1,-1};
    }
}

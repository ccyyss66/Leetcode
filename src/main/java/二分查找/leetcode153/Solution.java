package main.java.二分查找.leetcode153;

/**
 * 二分法, 二分法就是找与mid判断条件,这里我们选用right
 *
 * 当nums[mid] > nums[right]说明在mid左半边的递增区域, 说明最小元素在> mid区域
 *
 * 当nums[mid] <= nums[right说明在mid右半边的递增区域, 说明最小元素在<= mid区域
 *
 * 小技巧:
 *
 * 一般是这样,
 *
 * 当while left < right是循环外输出
 *
 * 当while left <= right是循环里输出
 *
 */
public class Solution {
    public int findMin1(int[] nums) {
        int len = nums.length;
        if (len<=1) return nums[0];
        int left = 0,right = len - 1;
        while (left<right){
            int mid = (left+right)/2;
            if (mid==0 && nums[mid+1]>nums[mid]) return nums[mid];
            if (mid==0 && nums[mid+1]<nums[mid]) return nums[mid+1];
            if (mid==len-1 &&nums[mid-1]>nums[mid]) return nums[mid];
            if (mid==len-1 &&nums[mid-1]<nums[mid]) return nums[mid-1];
            if (nums[mid]<nums[mid-1]&&nums[mid]<nums[mid+1]) return nums[mid];
            if (nums[mid]>nums[mid-1]&&nums[mid]>nums[mid+1]) return nums[mid+1];
            if (nums[mid]>nums[left] && nums[mid]>nums[right]) left= mid+1;
            else right = mid-1;
        }
        return nums[left];
    }
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }
        return nums[left];
    }

}

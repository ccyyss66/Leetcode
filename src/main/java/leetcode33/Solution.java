package main.java.leetcode33;

public class Solution {
    public int search(int[] nums, int target) {
        int length = nums.length;
        int left = 0, right = length -1, mid = (left + length - 1)/2;
        if (target == nums[0]) return 0;
        while (left<=right){
            mid = (left + right)/2;
            if (nums[mid] == target) return mid;
            else {
               if (nums[left]<=nums[mid]){
                   if (target < nums[mid]&&target>=nums[left]) right = mid -1;
                   else left = mid + 1;
               }
               else {
                   if (target > nums[mid] && target <= nums[right]) left = mid +1;
                   else right = mid - 1;
               }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int s[] = {4,5,6,7,8,1,2,3};
        Solution solution =new Solution();
        solution.search(s,8);
    }
}

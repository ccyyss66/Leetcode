package main.java.双指针.leetcode209;

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        if (len<=0) return 0;
        if (len==1 ) {
            if (nums[0]>=s)
            return 1;
            else return 0;
        }
        int i=0,j=0,min=Integer.MAX_VALUE;
        int sum=0;
        while (i<=j && j<len){
            sum +=nums[j];
            if (sum>=s){
                min = Math.min(min,j-i+1);
                sum = sum - nums[i];
                i++;
            }
            else {
                j++;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minSubArrayLen(7,new int[]{2,3,1,2,4,3});
    }
}

package main.java.leetcode260;

public class Solution {
    public int[] singleNumber(int[] nums) {
        int len = nums.length;
        int x=0;
        for (int num:nums){
            x ^=num;
        }
        int sign = x&(-x);
        int a=0,b;
        for (int num:nums){
            if ((num & sign) != 0) {
                a ^=num;
            }
        }
        return new int[]{a,a^x};
    }
}

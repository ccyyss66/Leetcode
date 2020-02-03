package main.java.贪心.leetcode45;

public class Solution {
    public int jump(int[] nums) {
        int len  = nums.length;
        if (len==0) return 0;
        int max =0;
        int step = 0;
        int s = 0;
        for (int i=0;i<len-1;i++){
            max=Math.max(max,nums[i]+i);
            if (s == i){
                s = max;
                step++;
            }
        }
        return step;
    }
}

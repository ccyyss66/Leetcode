package main.java.leetcode55;

public class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int zero=0;
        for (int i=0;i<len;i++){
            if (nums[i]==0){
                boolean canJump = false;
                for (int j=0;j<i;j++){
                    if (nums[j]>j-i ||(nums[j]==j-1 &&i==len)) {
                        canJump = true;
                        break;
                    }
                    if (canJump == false) return false;
                }
            }
        }
        return true;
    }
}

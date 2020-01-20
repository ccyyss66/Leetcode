package main.java.leetcode26;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int length =nums.length;
        if (length==0) return 0;
        int pos = 0;
        for (int i=1;i<length;i++){
            if (nums[i]!=nums[i-1]){
                pos++;
                nums[pos] = nums[i];
            }
        }
        return pos;
    }
}

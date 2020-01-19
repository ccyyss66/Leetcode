package main.java.leetcode31;

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        int temp,pos=0,min;
        for (int i=length-1;i>=1;i--){
            if (nums[i] > nums[i-1]) {
                min = i;
                for (int j=i+1;j<length-1;j++) {
                    if (nums[j] >nums[i-1]){
                        if (nums[min] > nums[j])
                            min = j;
                    }
                }
                temp = nums[min];
                nums[min] = nums[i-1];
                nums[i-1] = temp;
                pos = 1;
                Arrays.sort(nums,i,length);
                break;
            }
         }
        if (pos == 0){
            for (int i=0;i<length/2;i++){
                temp = nums[i];
                nums[i] = nums[length -1 -i];
                nums[length-1-i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] s={1,3,2};
        Solution solution = new Solution();
        solution.nextPermutation(s);
    }
}

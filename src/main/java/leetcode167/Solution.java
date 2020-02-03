package main.java.leetcode167;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left  = 0, right = numbers.length-1;
        while (left<right){
            if (numbers[left]+numbers[right]==target) break;
            else if (numbers[left]+numbers[right]>target) right--;
            else left++;
        }
        return new int[] {left,right};
    }
}

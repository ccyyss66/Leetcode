package main.java.leetcode41;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i=0;i<len;i++){
            while (nums[i]<=len && nums[i]>0 && nums[nums[i]-1]!=nums[i]){
                    swap(nums,i,nums[i]-1);
            }
        }
        for (int i=0;i<len;i++){
            if (nums[i]!=i+1)
                return i+1;
        }
        return len+1;
    }
    private void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] x = {3,4,-1,1};
        Solution solution = new Solution();
        solution.firstMissingPositive(x);
    }
}

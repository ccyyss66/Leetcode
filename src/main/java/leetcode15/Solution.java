package main.java.leetcode15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 使用双指针解决问题，时间复杂度为O(n2)
 **/
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length <3) return lists;
        int i,j;//双指针
        for (int k = 0;k < nums.length - 2;k++){
            if (nums[k] > 0) break;
            if (k > 0 && nums[k] == nums[k-1]) continue; //去重复
            i = k +1; j = nums.length - 1;
            while (i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    i++;
                }
                else if (sum >0){
                    j--;
                }
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[k]);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    lists.add(list);
                    while (i<j && nums[i] == nums[++i]); //去重
                    while (i<j && nums[j] == nums[--j]); //去重
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
     int[] s={-1,0,1,2,-1,-4};
     Solution solution = new Solution();
     solution.threeSum(s);
    }
}

package main.java.leetcode46;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯算法
 * python直接支持全排列函数：
 * def permute(self, nums: List[int]) -> List[List[int]]:
 *         return list(itertools.permutations(nums))
 *
 */
public class Solution {
    private void per(List<List<Integer>> lists,List<Integer> list,int[] visit,int[] nums,int count){
        if (count == nums.length) {
            List<Integer> a = new ArrayList<>();
            a.addAll(list);
            lists.add(a);
            return;
        }
        for (int i =0;i<nums.length;i++){
            if (visit[i] == 0) {
                list.add(nums[i]);
                visit[i] = 1;
                count++;
                per(lists, list, visit, nums, count);
                visit[i] = 0;
                count--;
                list.remove(count);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List lists = new ArrayList();
        List<Integer> list = new ArrayList<>();
        int length = nums.length;
        int count = 0;
        int[] visit = new int[length];
        for (int i=0;i<length;i++){
            visit[i] = 0;
        }
        per(lists,list,visit,nums,count);
        return lists;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        Solution solution = new Solution();
        solution.permute(a);
    }

}

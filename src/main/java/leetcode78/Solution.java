package main.java.leetcode78;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
//        lists.add(list);
        dfs(nums,0,list);
        return lists;
    }
    private void dfs(int[] nums,int pos,List<Integer> list){
        List<Integer> newList = new ArrayList<>();
        newList.addAll(list);
        lists.add(newList);
        for (int i=pos;i<nums.length;i++){
            list.add(nums[i]);
            dfs(nums,pos+1,list);
            list.remove(list.size()-1);
        }

    }
}

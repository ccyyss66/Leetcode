package main.java.leetcode39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    int len=0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> lists = new ArrayList<>();
        len = candidates.length;
        if (len<=0)return lists;
        List<Integer> list = new ArrayList<>();
        dfs(lists,list,candidates,target,0,0);
        return lists;
    }
    private void dfs(List<List<Integer>> lists,List<Integer> list,int[] candidates,int target,int now,int pos){
        if (now == target){
            List<Integer> newlist = new ArrayList<>();
            newlist.addAll(list);
            lists.add(newlist);
            return;
        }
        for (int i=pos;i<len;i++){
            if (candidates[i]+now<=target){
                list.add(candidates[i]);
                dfs(lists,list,candidates,target,now+candidates[i],i);
                list.remove(list.size()-1);
            }
        }

    }
}

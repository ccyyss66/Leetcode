package main.java.leetcode435;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length<=1) return 0;
        Comparator<int[]> cmp =new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        };
        Arrays.sort(intervals,0,intervals.length,cmp);
        int count =0;
        int end = intervals[0][1];
        for (int i=1;i<intervals.length;i++){
            if (end > intervals[i][0]){
                if (end > intervals[i][1])
                    end = intervals[i][1];
                count = count + 1;
            }else{
                end = intervals[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int a[][] = {{0,2},{1,3},{2,4},{3,5},{4,6}};
        Solution solution = new Solution();
        solution.eraseOverlapIntervals(a);
    }
}

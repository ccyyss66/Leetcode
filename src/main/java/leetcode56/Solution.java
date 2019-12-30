package main.java.leetcode56;


/**
 * 复杂度分析
 *
 * 时间复杂度：O(nlogn)
 *
 * 除去 sort 的开销，我们只需要一次线性扫描，所以主要的时间开销是排序的 O(nlgn)O(nlgn)
 *
 * 空间复杂度：O(1)(or O(n))
 *
 * 如果我们可以原地排序 intervals ，就不需要额外的存储空间；否则，我们就需要一个线性大小的空间去存储 intervals 的备份，来完成排序过程。
 *
 */

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Comparator<int[]> cmp = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        };
        Arrays.sort(intervals,0,intervals.length,cmp);
        list.add(intervals[0]);
        int l = 0;
        for (int i=1;i<intervals.length;i++){
            if (list.get(l)[1] >= intervals[i][0]){
                if (list.get(l)[1]<intervals[i][1])
                    list.get(l)[1] = intervals[i][1];
            }
            else{
                list.add(intervals[i]);
                l = l + 1;
            }
        }
        return list.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] x ={{1,4},{0,4}};
        Solution solution =new Solution();
        solution.merge(x);
    }
}

package main.java.sort.leetcode215;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return qSort(nums,0,nums.length-1,k);
    }
    public int qSort(int[] s,int low,int high,int k){
        if (low<high){
            int part = partition(s,low,high);
            if (part == k-1 ) return s[part];
            else if (part > k-1) return qSort(s,low,part-1,k);
            else return qSort(s,part+1,high,k);
        }
        return s[low];
    }
    public int partition(int[] s,int low,int high){
        int pivot = s[low];
        while (low < high){
            while (low < high && s[high] <= pivot) high--;
            s[low] = s[high];
            while (low<high && s[low] >= pivot) low++;
            s[high] = s[low];
        }
        s[low] = pivot;
        return low;
    }
}

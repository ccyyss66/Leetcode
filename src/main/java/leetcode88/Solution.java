package main.java.leetcode88;

public class Solution {
    /**
     * 自下而上，不需要额外空间复杂度
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1,j=n-1;
        int len = m+n-1;
        while (j>=0 && i>=0){
            nums1[len] = (nums1[i]>nums2[j]) ? nums1[i--]:nums2[j--];
            len--;
        }
        if (j>=0){
            for (int k=j;k<=0;k--){
                nums1[len] = nums2[k];
                len--;
            }
        }

    }

    public static void main(String[] args) {
        int[] a={3,3,3,0,0,0};
        int[] b={1,1,1};
        Solution solution = new Solution();
        solution.merge(a,3,b,3);
    }
}

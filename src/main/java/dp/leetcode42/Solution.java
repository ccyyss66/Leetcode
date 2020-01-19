package main.java.dp.leetcode42;

/**
 * 接雨水，一定要想到如何解题
 */
public class Solution {
    public int trap1(int[] height) {
        int sum = 0;
        int max_left = 0;
        int[] max_right = new int[height.length];
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            max_left = Math.max(max_left, height[i - 1]);
            int min = Math.min(max_left, max_right[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    public int trap2(int[] height){
        int sum = 0;
        int max_left =0;
        int max_right = 0;
        int left = 1;
        int right = height.length - 2;
        for (int i=1;i<height.length - 1;i++){
            if (height[left - 1]<height[right +1]){
                max_left = Math.max(max_left, height[left - 1]);
                if (height[left] < max_left){
                    sum +=max_left - height[left];
                }
                left++;
            }else {
                max_right = Math.max(max_right, height[right + 1]);
                if (height[right] < max_right){
                    sum +=max_right - height[right];
                }
                right--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] s = {5,4,1,2};
        Solution solution = new Solution();
        solution.trap2(s);
    }
}

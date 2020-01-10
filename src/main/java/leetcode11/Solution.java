package main.java.leetcode11;

public class Solution {
    /**
     * 方法一：优化的暴力法
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        int maxArea = 0;
        for (int i=0;i<height.length;i++){
            if (i > 0 && height[i] < height[i-1]) continue;
            for (int j=i+1;j<height.length;j++){
                maxArea = Math.max(maxArea, (j-i)*Math.min(height[i],height[j]));
            }
        }
        return maxArea;
    }

    /**
     * 方法二：双指针
     * @param height
     * @return
     */
    public int maxArea2(int[] height){
        int res = 0;
        int i = 0,j = height.length - 1;
        while(i < j){
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]):
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }

}

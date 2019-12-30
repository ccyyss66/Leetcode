package main.java.stack.leetcode84;

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0,pop;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        if (heights.length == 0) return 0;
        stack.push(0);
        for (int i=1;i<heights.length;i++){
            while (stack.peek()!= -1 && heights[i] < heights[stack.peek()]){
                pop = stack.pop();
                maxArea = Math.max(maxArea,heights[pop] *(i - stack.peek()-1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1){
            pop = stack.pop();
            maxArea = Math.max(maxArea,heights[pop] *(heights.length -1 - stack.peek()));

        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] x={2,1,5,6,2,3};
        Solution solution = new Solution();
        System.out.println(solution.largestRectangleArea(x));
    }
}

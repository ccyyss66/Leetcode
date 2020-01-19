package main.java.dp.leetcode32;

import java.util.Stack;

public class Solution {
    public int longestValidParentheses1(String s) {
        int len = s.length();
        if (len<=0) return 0;
        int dp[] = new int[len];
        int satrt = 0;
        int max =0;
        while ( satrt<len  && s.charAt(satrt) !='(' ){
            dp[satrt] = 0;
            satrt++;
        }
        if (satrt == len) return 0;
        dp[satrt] = 0;
        for (int i=satrt+1;i<len;i++){
            if (s.charAt(i)==')'){
                if (s.charAt(i - 1) == '('){
                    if (i-2>=0)
                    dp[i] = dp[i-2]+2;
                    else dp[i]=2;
                }
                else if (i-dp[i-1]-1 >=0 && s.charAt(i-dp[i-1]-1) == '(')
                    if (i-dp[i-1]-2 >=0) dp[i] = dp[i-dp[i-1]-2]+dp[i-1]+2;
                    else
                    dp[i] = dp[i-1]+2;
                else
                    dp[i] = 0;
            }
            else {
                dp[i] = 0;
            }
            max = Math.max(dp[i],max);
        }
        System.out.println(max);
        return max;
    }
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    /**
     * 栈，很巧妙
     * @param s
     * @return
     */
    public int longestValidParentheses2(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }


    public static void main(String[] args) {
        String s ="()(())())()()()()())";
        Solution solution = new Solution();
        solution.longestValidParentheses(s);
    }
}

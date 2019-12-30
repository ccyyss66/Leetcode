package main.java.leetcode10;

/**
 * 优秀思路：
 * https://leetcode-cn.com/problems/regular-expression-matching/solution/dong-tai-gui-hua-zen-yao-cong-0kai-shi-si-kao-da-b/
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        int slength = s.length(),plength = p.length();

        if (p == null || s == null) return false;
        /**
         * dp[i][j] 表示s的前i个字符能不能p的前j个字符匹配上
         */
        boolean[][] dp = new boolean[slength+1][plength+1];
        dp[0][0] = true;
        for (int i=1;i <= plength;i++){
            if (i>1 && p.charAt(i-1) == '*' && dp[0][i-2]){
                dp[0][i] = true;
            }
        }
        for (int i=1;i<=slength;i++){
            for (int j=1;j<=plength;j++){
                if (p.charAt(j-1) != '*'){
                    dp[i][j] = dp[i-1][j-1] && (p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '.');
                }
                else {
                    if (s.charAt(i-1) != p.charAt(j-2) && p.charAt(j-2) != '.')//如果前一个元素不匹配 且不为任意元素
                        dp[i][j] = dp[i][j-2];

                    else {//如果前一个字符匹配，表示0-n个字符串的时候
                        dp[i][j] = (dp[i-1][j] && (p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) == '.')) || dp[i][j-2];
                    }
                }
            }
        }
        return dp[slength][plength];
    }

    public static void main(String[] args) {
        String s = "aaa";
        String p = "ab*a*c*a";
        Solution solution =new Solution();
        System.out.println(solution.isMatch(s,p));
    }
}

package main.java.dp.leetcode44;

public class Solution {
    public boolean isMatch(String s, String p) {
        int len2 = s.length();
        int len1 = p.length();
        int[][] dp = new int[len1+1][len2+1];
            for (int i=0;i<len1;i++){
                if (p.charAt(i)!='*')
                    break;
                else dp[i+1][0] = 1;
            }

        dp[0][0] = 1;
        for (int i=1;i<=len1;i++){
            for (int j=1;j<=len2;j++){
                if (s.charAt(j-1) == p.charAt(i-1) || p.charAt(i-1) == '?')
                    dp[i][j] = dp[i-1][j-1];
                else if (p.charAt(i-1) == '*'){
                    if(dp[i][j-1]!=1) dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1]);
                    else dp[i][j] =1;
                }
            }
        }
        return dp[len1][len2]==1;
    }

    public static void main(String[] args) {
        String a = "";
        String b ="*";
        Solution solution = new Solution();
        System.out.println(solution.isMatch(a,b));
    }
}

package main.java.leetcode91;

public class Solution {
    int sums = 0;
    public int numDecodings1(String s) {
        int len = s.length();
        dfs(s,len,0);
        return sums;
    }
   private void dfs(String s,int len,int pos){
        if (pos == len-1) {
            sums++;
            return;
        }
        if (pos>len-1) return;
        if (s.charAt(pos)>'0' && s.charAt(pos)<='9'){
            dfs(s,len,pos+1);
        }
        if (pos<len-1){
            int p = (s.charAt(pos)-'0')*10+(s.charAt(pos+1)-'0');
            if (p>=10&&p<=26)
                dfs(s,len,pos+2);
        }
   }
    public int numDecodings(String s) {
        int len = s.length();
        int sum = 0;
        int dp[] = new int[len+1];
        if (s.charAt(0)=='0') return 0;
        if (s.charAt(0)>'0') dp[0] = 1;
        if (len ==1)return dp[0];
        int p = (s.charAt(0)-'0')*10+(s.charAt(0+1)-'0');
        if (p==20 ||p==10) dp[1] = 1;
        else if (p>10&&p<=26) dp[1] = 2;
        else if (p>26 && p % 10 == 0)dp[1] = 0;
        else dp[1] =1;
        for (int i=2;i<len;i++){
            p = (s.charAt(i-1)-'0')*10+(s.charAt(i)-'0');
            if (s.charAt(i)>'0' && (p>=10&&p<=26)) dp[i] = dp[i-1]+dp[i-2];
            else if (s.charAt(i)>'0') dp[i] = dp[i-1];
            else if ((p>=10&&p<=26)) dp[i] =dp [i-2];
        }
        return dp[len-1];
    }
}

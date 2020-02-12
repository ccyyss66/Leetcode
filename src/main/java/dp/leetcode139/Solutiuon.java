package main.java.dp.leetcode139;

import java.util.List;

public class Solutiuon {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        if (len<=0) return true;
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        for (int i=1;i<=len;i++){
            for (int j=0;j<wordDict.size();j++){
                if (i-wordDict.get(j).length()>=0  && dp[i-wordDict.get(j).length()]){
                    if (wordDict.get(j).equals(s.substring(i-wordDict.get(j).length(),i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[len];
    }
}

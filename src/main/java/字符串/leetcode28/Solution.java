package main.java.字符串.leetcode28;

public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length()==0) return 0;
        if (haystack.length()==0) return -1;
        for (int i=0;i<haystack.length()-needle.length()+1;i++){
            if (haystack.charAt(i) == needle.charAt(0)){
                boolean com = true;
                for (int j=0;j<needle.length();j++){
                    if ( needle.charAt(j)!=haystack.charAt(i+j)){
                        com = false;
                        break;
                    }
                }
                if (com) return i;
            }
        }
        return -1;
    }
}

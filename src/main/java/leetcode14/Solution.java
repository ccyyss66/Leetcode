package main.java.leetcode14;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String com = "";
        boolean pos = true;
        int length = strs[0].length();
        for (int i=0;i<length;i++){
            for (int j=1;i<strs.length;j++){
                if (i>=strs[j].length() || strs[0].charAt(i)!=strs[j].charAt(i)) {
                    pos = false;
                    break;
                }
            }
            if (pos == false ) break;
            com = com+strs[0].charAt(i);
        }
        return com;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] s = new String[] {"flower","flow","flood"};
        solution.longestCommonPrefix(s);
    }
}

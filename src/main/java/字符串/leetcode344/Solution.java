package main.java.字符串.leetcode344;

public class Solution {
    public void reverseString(char[] s) {
        int len = s.length;
        if (len<=1) return;
        int left=0,right = len-1;
        while (left<right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        return;
    }
}

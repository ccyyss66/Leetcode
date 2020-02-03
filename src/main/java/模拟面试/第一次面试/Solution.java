package main.java.模拟面试.第一次面试;

public class Solution {
    public void reverseString(char[] s) {
        int length = s.length;
        if (length<=1) return;
        int mid = (length+1)/2;
        for (int i=0;i<mid;i++){
            char tmp = s[i];
            s[i] = s[length-1-i];
            s[length-1-i] = tmp;
        }
    }
}

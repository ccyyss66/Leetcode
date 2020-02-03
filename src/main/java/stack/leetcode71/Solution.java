package main.java.stack.leetcode71;

import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        int len = path.length();
        Stack<String> stringStack = new Stack<>();
        String s = "";
        for (int i=0;i<len;i++){
            if (path.charAt(i)!='/'){
                s = s + path.charAt(i);
            }
            if ((i==len-1 && path.charAt(i)!='/') || (path.charAt(i)!='/'&&path.charAt(i+1)=='/')){
                String s1 = new String();
                s1 = s;
                if (s1.equals("..")) {
                    if (!stringStack.empty())
                    stringStack.pop();
                }else if (s1.equals(".")){
                }
                else {
                    stringStack.push(s1);
                }
                s = "";
            }
        }

        String s2 = "";
        while (!stringStack.empty()){
            s2 ="/"+stringStack.pop()+s2;
        }
        if (s2=="")
            return "/";
        return s2;
    }

    public static void main(String[] args) {
        String s ="/a//b////c/d//././/..";
        Solution solution = new Solution();
        solution.simplifyPath(s);
    }
}

package main.java.stack.leetcode20;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class Solution {
    /**
     * 自己写的，感觉太复杂
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s.length() ==0) return true;
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i =1;i<s.length();i++){
            if (s.charAt(i) == '(' || s.charAt(i) == '[' ||s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }
            else {
                if (!stack.empty()) {
                    switch (s.charAt(i)) {
                        case ')':
                            if (stack.peek() == '(') {
                                stack.pop();
                            } else return false;
                            break;
                        case ']':
                            if (stack.peek() == '[') {
                                stack.pop();
                            } else return false;
                            break;
                        case '}':
                            if (stack.peek() == '{') {
                                stack.pop();
                            } else return false;
                            break;
                    }
                }
                else return false;
            }
        }
    if (stack.empty())
    return true;
    else return false;
    }


    private static final Map<Character,Character> map = new HashMap<Character,Character>(){{
        put('{','}'); put('[',']'); put('(',')'); put('?','?');
    }};
    public boolean isValid2(String s) {
        if(s.length() > 0 && !map.containsKey(s.charAt(0))) return false;
        LinkedList<Character> stack = new LinkedList<Character>() {{ add('?'); }};
        for(Character c : s.toCharArray()){
            if(map.containsKey(c)) stack.addLast(c);
            else if(map.get(stack.removeLast()) != c) return false;
        }
        return stack.size() == 1;
    }

}

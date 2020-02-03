package main.java.模拟面试.第二次面试;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public int maxNumberOfBalloons(String text) {
        Map<String,Integer> s = new HashMap<>();
        s.put("b",0);
        s.put("a",0);
        s.put("l",0);
        s.put("o",0);
        s.put("n",0);
        for (int i=0;i<text.length();i++){
            if (s.containsKey(String.valueOf(text.charAt(i)))){
                int value = s.get(String.valueOf(text.charAt(i)));
                s.put(String.valueOf(text.charAt(i)),value+1);
            }
        }
        int min = Integer.MAX_VALUE;
        for(String key : s.keySet()){
            Integer value = s.get(key);
            if (key.equals("o")|| key.equals("l"))
                min = Math.min(min,value/2);
            else min = Math.min(min,value);
        }
        if (min == Integer.MAX_VALUE) min = 0;
        return min;
    }
}

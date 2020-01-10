package main.java.leetcode93;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new LinkedList<>();
        StringBuilder ss= new StringBuilder();
        for(int a = 1 ; a < 4 ; ++ a)
            for(int b = 1 ; b < 4 ; ++ b)
                for(int c = 1 ; c < 4 ; ++ c)
                    for(int d = 1 ; d < 4 ; ++ d){
                        if (a+b+c+d == s.length()) {
                            int n1 = Integer.getInteger(s.substring(0,a));
                            int n2 = Integer.getInteger(s.substring(a,a+b));
                            int n3 = Integer.getInteger(s.substring(a+b,a+b+c));
                            int n4 = Integer.getInteger(s.substring(a+b+c));
                            if(n1 <= 255 && n2 <= 255 && n3 <= 255 && n4 <= 255){
                               ss.append(n1).append('.').append(n2)
                                       .append('.').append(n3).append('.').append(n4);
                               if (ss.length() == s.length()+3) list.add(ss.toString());
                               ss.delete(0,ss.length());

                            }
                        }
                    }
    return list;
    }
}

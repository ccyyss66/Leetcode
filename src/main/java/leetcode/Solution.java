package main.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> numbers =new ArrayList<String>(Arrays.asList(new String[]{"", "", "abc", "def","ghi","jkl","mno","pqrs","tuv","wxyz"}));
        List<String> result = new ArrayList<>();
        int len = digits.length();
        if (len==0)
            return result;
        String s = "";
        allsort(result,numbers,digits,s,0,len);
        return numbers;
    }
    private void allsort(List<String> result,List<String> numbers,String digits,String s,int pos,int len){
        if (pos==len) {
            result.add(s);
            return;
        }
        else {
            int number = digits.charAt(pos)-'0';
            for (int i =0;i<numbers.get(number).length();i++){
                allsort(result,numbers,digits,s+numbers.get(number).charAt(i),pos+1,len);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> a =solution.letterCombinations("");
    }
}

package main.java.leetcode135;

/**
 * 贪心：
 * 左右各遍历一遍
 * 左规则：要求rating比左边高的，candy比左边的多
 * 右规则：要求rating比右边高的，candy比右边多
 * 相邻的学生中，评分高的学生必须获得更多的糖果 等价于 所有学生满足左规则且满足右规则。
 */
public class Solution {
    public int candy(int[] ratings) {
        int length = ratings.length;
        int[] candy = new int[length];
        for (int i=0;i<length;i++){
            candy[i]  = 1;
        }
        for (int i=1;i<length;i++){
            if (ratings[i] > ratings[i-1])
                candy[i] = candy[i-1]+1;
        }
        for (int i = length - 2; i>=0;i--){
            if (ratings[i] >ratings[i+1]){
                if (candy[i] <= candy[i+1]+1){
                    candy[i] = candy[i+1]+1;
                }
            }
        }
        int sum =0;
        for (int i=0;i<length;i++){
            sum +=candy[i];
        }
        return sum;
    }
}

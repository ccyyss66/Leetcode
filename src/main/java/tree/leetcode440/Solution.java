package main.java.tree.leetcode440;

/**
 * 难！抽象前序遍历10叉数
 */
public class Solution {
    private int getRank(int prefix,int n){
        long next = prefix + 1;
        long cur = prefix;
        int count = 0;
        while (cur <= n){
            count += Math.min(n+1,next) - cur; // 注意这里是n+1 可以举例去感受
            next = next * 10;  //java int型最大-2147483648——2147483647,*10容易越界所以只能用long
            cur = cur * 10;
        }
        return count;
    }
    public int findKthNumber(int n, int k) {
        int rank=1,count;
        int prefix = 1;
        while (rank < k){
            count = getRank(prefix,n); //以predfix为前缀的数有多少
            if (rank + count >k){
                prefix = prefix * 10;
                rank++;
            }
            else {
                rank = rank + count;
                prefix ++;
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findKthNumber(681692778,
                351251360));
    }
}

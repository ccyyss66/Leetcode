package main.java.tree.leetcode112;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
       return dfs(root,0,sum);
    }
    private boolean dfs(TreeNode root,int now,int sum){
        if (now == sum) return true;
        if (root!= null)
        now +=root.val;
        else return false;
        return dfs(root.left,now,sum)||dfs(root.right,now,sum);
    }
}

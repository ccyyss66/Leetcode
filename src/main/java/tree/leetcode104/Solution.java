package main.java.tree.leetcode104;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public int maxDepth(TreeNode root) {
        int max = dfs(root);
        return max;
    }
    public int dfs(TreeNode root){
        if (root == null) return 0;
        return 1+Math.max(dfs(root.left),dfs(root.right));
    }
}

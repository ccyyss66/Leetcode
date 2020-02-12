package main.java.tree.leetcode226;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root==null) return null;
        if (root.left!=null ||root.right!= null){
            TreeNode temp = invertTree(root.left);
            root.left = invertTree(root.right);
            root.left = temp;
            return root;
        }
        else return root;
    }
}

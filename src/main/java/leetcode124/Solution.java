package main.java.leetcode124;



import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int maxPathSum1(TreeNode root) {
        int max = Integer.MIN_VALUE;
        Queue<TreeNode> e = new LinkedList();
        if (root == null) return max;
        e.add(root);
        while (!e.isEmpty()){
            int nodeMax =0,leftmax=0,rightmax=0;
            TreeNode node = e.poll();
            leftmax = dfs(node.left);
            rightmax = dfs(node.right);
            nodeMax = Math.max(leftmax+node.val,Math.max(node.val+rightmax,node.val+leftmax+rightmax));
            max = Math.max(max,Math.max(nodeMax,node.val));
            if (node.left!=null) e.add(node.left);
            if (node.right!=null)e.add(node.right);
        }
        return 0;
    }
    private int dfs(TreeNode root){
        if (root==null) return 0;

        return (Math.max(root.val+dfs(root.left),Math.max(root.val+dfs(root.right),root.val)));
    }
    /**
     * 靠全局变量改进版
     */
    private int max =Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs1(root);
        if (root==null) return 0;
        return max;
    }
    private int dfs1(TreeNode node){
        if (node == null) return 0;
        int left = dfs1(node.left);
        int right = dfs1(node.right);
        max =Math.max(max,node.val+left+right);
        return Math.max(0,Math.max(left,right)+node.val);
    }
}

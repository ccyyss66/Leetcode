package main.java.tree.leetcode199;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        TreeNode front = root;
        TreeNode last = root,node,rear=root;
        queue.add(root);
        while (!queue.isEmpty()){
            node = queue.poll();
            if (node.left != null)  { queue.add(node.left); rear =node.left;}
            if (node.right != null) { queue.add(node.right); rear = node.right;}
            if (node == last) {
                list.add(last.val);
                last = rear;
            }

        }
        return list;
    }
}

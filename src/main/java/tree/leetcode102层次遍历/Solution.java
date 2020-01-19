package main.java.tree.leetcode102层次遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList();
        List<Integer> list = new LinkedList<>();
        TreeNode front = root;
        TreeNode last = root,node,rear=root;
        queue.add(root);
        while (!queue.isEmpty()){
            node = queue.poll();
            list.add(last.val);
            if (node.left != null)  { queue.add(node.left); rear =node.left;}
            if (node.right != null) { queue.add(node.right); rear = node.right;}
            if (node == last) {
                lists.add(list);
                last = rear;
                list = new LinkedList<>();
            }

        }
        return lists;
    }
}

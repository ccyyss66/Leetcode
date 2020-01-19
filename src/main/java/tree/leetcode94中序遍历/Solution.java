package main.java.tree.leetcode94中序遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    private void inorder(TreeNode node, List<Integer> list){
        if (node.left != null) inorder(node.left,list);
        list.add(node.val);
        if (node.right != null) inorder(node.right,list);
    }

    /**
     * 非递归，使用栈
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        Stack< TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    /**
     * 非递归，使用线索二叉树，莫里斯遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> ldr = new ArrayList<Integer>();
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur!=null){
            if(cur.left==null){//左子树为空，输出当前节点，将其右孩子作为当前节点
                ldr.add(cur.val);
                cur = cur.right;
            }
            else{
                pre = cur.left;//左子树
                while(pre.right!=null&&pre.right!=cur){//找到前驱节点，即左子树中的最右节点
                    pre = pre.right;
                }
                //如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。当前节点更新为当前节点的左孩子。
                if(pre.right==null){
                    pre.right = cur;
                    cur = cur.left;
                }
                //如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空（恢复树的形状）。输出当前节点。当前节点更新为当前节点的右孩子。
                if(pre.right==cur){
                    pre.right = null;
                    ldr.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return ldr;
    }

        class ColorNode {
            TreeNode node;
            String color;

            public ColorNode(TreeNode node, String color) {
                this.node = node;
                this.color = color;
            }
        }
        /**
         * 颜色标记法
         * @param root
         * @return
         */
        public List<Integer> inorderTraversal(TreeNode root) {
            if(root == null) return new ArrayList<Integer>();

            List<Integer> res = new ArrayList<>();
            Stack<ColorNode> stack = new Stack<>();
            stack.push(new ColorNode(root,"white"));

            while(!stack.empty()){
                ColorNode cn = stack.pop();
                if(cn.color.equals("white")){
                    if(cn.node.right != null) stack.push(new ColorNode(cn.node.right,"white"));
                    stack.push(new ColorNode(cn.node,"gray"));
                    if(cn.node.left != null)stack.push(new ColorNode(cn.node.left,"white"));
                }else{
                    res.add(cn.node.val);
                }
            }
            return res;
        }
    }



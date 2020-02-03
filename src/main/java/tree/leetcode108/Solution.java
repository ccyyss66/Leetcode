package main.java.tree.leetcode108;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    int end;
    public TreeNode sortedArrayToBST(int[] nums) {
        end = nums.length-1;
        TreeNode root = createBST(nums,0,end);
        return root;
    }
    private TreeNode createBST(int[] nums,int left,int right){
        if (right>end || left<0 ||right<0 ||left>end) return null;
        int mid = (left + right) >>> 1; //注意越位问题
//        int mid = (left+right+1)/2;
        TreeNode node = new TreeNode(nums[mid]);
        if (left == right) return node;
        node.left = createBST(nums,left,mid-1);
        node.right = createBST(nums,mid+1,right);
        return node;
    }

    public static void main(String[] args) {
        int[] s = {1,2,3,4,5};
        Solution solution = new Solution();
        solution.sortedArrayToBST(s);
    }
}

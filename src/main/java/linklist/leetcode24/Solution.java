package main.java.linklist.leetcode24;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode root = new ListNode(-1);
        ListNode pre = root;
        pre.next = head;
        ListNode node = head;
        while (node!=null &&node.next!=null){
            ListNode next = node.next;
            ListNode nextnext = next.next;
            next.next = node;
            pre.next = next;
            node.next = nextnext;
            pre = node;
            node = nextnext;
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Solution solution = new Solution();
        solution.swapPairs(node1);
    }
}

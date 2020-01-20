package main.java.linklist.leetcode206;

import java.util.List;

class ListNode {
      int val;
      ListNode next;
 ListNode(int x) { val = x; }
 }

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode node = head,next;
        while(node!=null){
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        head.next = null;
        return pre;
    }
}

package main.java.linklist.leetcode19;

import java.util.List;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nodeA;
        ListNode nodepre = new ListNode(-1);
        nodeA  = head;
        nodepre.next = head;
        for (int i=0;i<n;i++){
            nodeA = nodeA.next;
        }
        while (nodeA!= null){
            nodeA = nodeA.next;
            nodepre = nodepre.next;
        }
        if (nodepre.next == head) return head.next;
        nodepre.next = nodepre.next.next;
        return head;
    }
}

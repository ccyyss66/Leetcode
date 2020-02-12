package main.java.linklist.leetcode82;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode pre = newHead;
        ListNode now = head;
        while (now!=null){
            ListNode next = now.next;
            if (next!=null && next.val == now.val){
                while (next!=null && next.val==now.val){
                    next = next.next;
                }
                pre.next = next;
                now = next;
            }else {
                pre = now;
                now = now.next;
            }
        }
        return newHead.next;
    }
}

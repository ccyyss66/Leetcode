package main.java.linklist.leetcode160;

public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;
            ListNode a,b;
            a = headA;
            b = headB;
            while (a!=b){
                if (a != null) a = a.next;
                else a = headB;
                if (b != null) b = b.next;
                else b = headA;
            }
            return a;
        }
}

package main.java.leetcode21;

 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode node = head;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                node.next = l1;
                l1 = l1.next;
            }
            else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
//        while (l1 != null){
//            node.next = l1;
//            l1 = l1.next;
//            node = node.next;
//        }
//        while (l2 != null){
//            node.next = l2;
//            l2 = l2.next;
//            node = node.next;
//        }
        node.next = l1 == null ? l2:l1;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        head1.next = head2;
        head2.next = head3;
        ListNode head4 = new ListNode(1);
        ListNode head5 = new ListNode(3);
        ListNode head6 = new ListNode(4);
        head4.next = head5;
        head5.next = head6;
        Solution solution =new Solution();
        solution.mergeTwoLists(head1,head4);
    }

}

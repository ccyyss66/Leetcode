package main.java.linklist.leetcode143;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public void reorderList(ListNode head) {
        ListNode node = head;
        int length = 0;
        while (node!=null){
            length++;
            node = node.next;
        }
        int mid = (length+1) / 2;
        node = head;
        ListNode pre = new ListNode(-1);
        for (int i=0;i<mid;i++){
            pre = node;
            node = node.next;
        }
        pre.next = null;
        ListNode newNode;
        if (node!=null) {
            newNode = reserve(node);
            while (newNode!=null){
                ListNode next = head.next;
                ListNode newnext = newNode.next;
                head.next = newNode;
                newNode.next = next;
                head = next;
                newNode = newnext;
            }
        }


    }
    private ListNode reserve(ListNode head){
        ListNode node = head;
        ListNode pre = new ListNode(-1);
        pre.next = node;
        while (node != null){
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        head.next = null;
        return pre;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode head = node;
        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(3);
        node = node.next;
        node.next = new ListNode(4);
        Solution solution = new Solution();
        solution.reorderList(head);
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}

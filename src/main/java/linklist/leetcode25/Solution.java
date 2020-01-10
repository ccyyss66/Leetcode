package main.java.linklist.leetcode25;

/**
 * 关于链表的反转还需要多
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode listNode = new ListNode(-1);
        listNode.next = head;
        ListNode pre,end,newhead;
        newhead = listNode;
        int p = 0;
        pre = end = listNode;
        while (listNode != null){
            if (p < k){
                p++;
                listNode = listNode.next;
                end = listNode;
            }
            else {
                p = 0;
                pre = listNode = reverse(pre,end);
            }
        }
        return newhead.next;
    }
    private ListNode reverse(ListNode head,ListNode end){
        ListNode node = head.next;
        ListNode  pre,next,tmp;
        pre = node;
        next = node.next;
        while (pre != end){
        tmp = next.next;
        next.next = pre;
        pre = next;
        next =tmp;


        }
        pre = head.next;
        head.next.next = next;
        head.next = end;
        return pre;
    }

    public static void main(String[] args) {
        int k =2;
        ListNode head = new ListNode(1);
        ListNode a = head;
        for (int i =0;i<4;i++){
            ListNode node = new ListNode(i+2);
            a.next = node;
            a = a.next;
        }
        Solution solution = new Solution();
        solution.reverseKGroup(head,k);
    }
}

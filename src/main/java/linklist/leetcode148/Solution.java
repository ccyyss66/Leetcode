package main.java.linklist.leetcode148;

public class Solution {
    public ListNode sortList1(ListNode head) {
        ListNode node = head;
        int len =0;
        while (node!=null){
            len++;
            node = node.next;
        }
        for (int t =1;t<len;t*=2){
            ListNode node1 = head;
            ListNode node2 = nextNode(node1,t);
            ListNode pre = new ListNode(0),s=pre;
            while (node1!=null && node2!=null){
                int c1=0,c2=0;
                while (c1<t && c2<t && node1 !=null && node2!=null){
                    if (node1.val<=node2.val){
                        pre.next = node1;
                        node1 = node1.next;
                        c1++;
                    }
                    else {
                        pre.next = node2;
                        node2 = node2.next;
                        c2++;
                    }
                    pre = pre.next;
                }
                while (c1<t && node1!=null){
                    pre.next = node1;
                    node1 =node1.next;
                    c1++;
                    pre = pre.next;
                }
                while (c2<t && node2!=null){
                    pre.next = node2;
                    node2 =node2.next;
                    c2++;
                    pre = pre.next;
                }
                pre.next = node2;
                node1 = node2;
                node2 = nextNode(node1,t);
            }
            head = s.next;
        }
        return head;
    }
    private ListNode nextNode(ListNode node,int t){
        ListNode nextNode = node;
        while (t>0 && nextNode!=null ){
            --t;
            nextNode = nextNode.next;
        }
        return nextNode;
    }

    /**
     * 自底向上
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }

}

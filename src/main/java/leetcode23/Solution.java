package main.java.leetcode23;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 优先队列（堆排序-->需自己会写）
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        Comparator<ListNode> comparators = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        };
        ListNode pre = new ListNode(-1);
        PriorityQueue<ListNode> queue = new PriorityQueue<>(comparators);
        for (ListNode listNode : lists) {
            if (listNode != null)
            queue.add(listNode);
        }
        ListNode now = pre;
        while (!queue.isEmpty()) {
            ListNode node = queue.remove();
            now.next = node;
            now = now.next;
            if (node.next != null) {
                node = node.next;
                queue.add(node);
            }
        }
        return pre.next;

}
    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = new ListNode(1);
        listNodes[0].next = new ListNode(4);
        listNodes[1]= new ListNode(1);
        listNodes[1].next = new ListNode(3);
        listNodes[2]= new ListNode(2);
        listNodes[2].next = new ListNode(6);
//        listNodes[2].next = new ListNode(5);
        Solution s= new Solution();
        s.mergeKLists(listNodes);
    }
}

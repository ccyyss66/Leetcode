package main.java.linklist.leetcode445;

import java.util.List;
import java.util.Stack;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 =new Stack<>();
        while (l1!=null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2!=null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int pos = 0;
        ListNode pre = new ListNode(-1);
        while (!stack1.empty() || !stack2.empty() || pos==1){
            int a=0,b=0;
            if (!stack1.empty()) a = stack1.pop();
            if (!stack2.empty()) b = stack2.pop();
            int val = pos + a + b;
            pos = val / 10;
            ListNode node = new ListNode(val % 10);
            ListNode nextnode = pre.next;
            pre.next = node;
            node.next = nextnode;
        }
        return pre.next;
    }
}

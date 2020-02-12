package main.java.stack.leetcode232;

import java.util.Stack;

public class MyQueue {

        Stack<Integer> stack1;
        Stack<Integer> stack2;
        int front;
        /** Initialize your data structure here. */
        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            if (stack1.empty()){
                    front = x;
            }
            stack1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (stack2.empty()){
                    while (!stack1.empty()){
                            stack2.push(stack1.pop());
                }
            }
           return stack2.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (stack2.empty()){
                return front;
            }
            else return stack2.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
           if (stack1.empty()&&stack2.empty()){
                   return true;
           }
           else return false;
        }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

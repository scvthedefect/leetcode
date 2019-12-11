package cn.lawrence.leetcode.solution.easy;

import java.util.Stack;

/**
 * 用栈实现队列功能 
 * 执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
 * 内存消耗 :33.8 MB, 在所有 java 提交中击败了69.12%的用户
 */
public class No232MyQueue {

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        System.out.println(String.format("peek: %d, expected: %d", 1, 1));
        System.out.println(String.format("pop: %d, expected: %d", 1, 1));
        System.out.println(String.format("peek: %d, expected: %d", 2, 2));
        System.out.println(String.format("pop: %d, expected: %d", 3, 3));
        System.out.println(String.format("peek: %d, expected: %d", 4, 4));
    }
    
}

class MyQueue {
    
    /** Initialize your data structure here. */
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.add(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int n = s1.size() - 1;
        while(n-- > 0) {
            s2.add(s1.pop());
        }
        int res = s1.pop().intValue();
        while(!s2.isEmpty()) {
            s1.add(s2.pop());
        }
        return res;
    }
    
    /** Get the front element. */
    public int peek() {
        int res = 0;
        Integer v;
        while(!s1.isEmpty()) {
            v = s1.pop();
            res = v.intValue();
            s2.add(v);
        }
        while(!s2.isEmpty()) {
            s1.add(s2.pop());
        }
        return res;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }
    
}
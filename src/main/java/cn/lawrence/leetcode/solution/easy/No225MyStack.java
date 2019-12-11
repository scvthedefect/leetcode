package cn.lawrence.leetcode.solution.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 * 执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
 * 内存消耗 :34.2 MB, 在所有 java 提交中击败了66.20%的用户
 */
public class No225MyStack {

    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        
        System.out.println(String.format("isEmpty: %b, expected: %b", s.empty(), false));
        System.out.println(String.format("pop: %d, expected: %d", s.pop(), 4));
        System.out.println(String.format("top: %d, expected: %d", s.top(), 3));
        System.out.println(String.format("pop: %d, expected: %d", s.pop(), 3));
        System.out.println(String.format("isEmpty: %b, expected: %b", s.empty(), false));
        
    }
    
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
class MyStack {
    Queue<Integer> q;
    public MyStack() {
        q = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int n = q.size() - 1;
        while(n-- > 0) {
            q.add(q.poll());
        }
        return q.poll();
    }
    
    /** Get the top element. */
    public int top() {
        int n = q.size();
        int res = 0;
        while(n-- > 0) {
            res = q.poll();
            q.add(res);
        }
        return res;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
    
}
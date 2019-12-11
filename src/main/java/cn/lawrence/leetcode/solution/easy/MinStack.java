package cn.lawrence.leetcode.solution.easy;

public class MinStack {
    
    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(2);
        s.push(0);
        s.push(3);
        s.push(0);
        s.getMin();
        s.pop();
        s.getMin();
        s.pop();
        s.getMin();
        s.pop();
        int last = s.getMin();
        System.out.println(last);
    }
    
    /** initialize your data structure here. */
    private int[] elem;
    private int cursor;
    private int minIndex;

    public MinStack() {
        elem = new int[16];
        cursor = -1;
    }
    
    public void push(int x) {
        if(cursor + 1 == elem.length) { // expand
            int[] newElem = new int[elem.length * 2];
            System.arraycopy(elem, 0, newElem, 0, elem.length);
            elem = newElem;
        }
        elem[++cursor] = x;

        // update min.
        if(x < getMin()) {
            minIndex = cursor;
        }
    }
    
    public void pop() {
        if(cursor >= 0) {
            cursor--;
        }

        minIndex = 0;
        for(int i = 0; i <= cursor; i++) {
            if(elem[i] < elem[minIndex]) {
                minIndex = i;
            }
        }
    }
    
    public int top() {
        return elem[cursor];
    }
    
    public int getMin() {
        return elem[minIndex];
    }

}

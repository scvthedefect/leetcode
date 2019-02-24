package cn.lawrence.leetcode.solution;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        this.val = x;
    }
    
    public static void main(String[] args) {
        // for testing
        ListNode node = new ListNode(1,2,3,4);
        node.output();
    }
    
    public ListNode(int...vals) {
        ListNode prev = null;
        for(int i = 0; i < vals.length; i++) {
            int v = vals[i];
            if(i == 0) {
                this.val = v;
                prev = this;
            } else {
                prev.next = new ListNode(v);
                prev = prev.next;
            }
        }
    }
    
    public void output() {
//        System.out.print(val);
//        System.out.print(", ");
//        
//        if(next != null) {
//            next.output();
//        }
//        System.out.println();
        
        System.out.print(val + ", ");
        
        ListNode node = this;
        while(node.next != null) {
            System.out.print(node.next.val + ", ");            
            node = node.next;
        }
        
        System.out.println();
        
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}

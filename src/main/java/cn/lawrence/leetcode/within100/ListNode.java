package cn.lawrence.leetcode.within100;

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
    
    ListNode(int...vals) {
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
}

package cn.lawrence.leetcode.common;

public class ListNode {
    public int val;
    public ListNode next;
    
    ListNode(int x) {
        this.val = x;
    }
    
    public static void main(String[] args) {
        // for testing
        ListNode node = new ListNode(1,2,3,4);
        node.output();
    }
    
    private int[] records;
    
    public int[] getRecords() {
        return this.records;
    }
    
    public ListNode(int...vals) {
        ListNode prev = null;
        for(int i = 0; i < vals.length; i++) {
            int v = vals[i];
            if(i == 0) {
                this.val = v;
                prev = this;
                
                this.records = vals;
            } else {
                prev.next = new ListNode(v);
                prev = prev.next;
            }
        }
    }
    
    public void output() {
        System.out.print(val);
        
        ListNode node = this;
        while(node.next != null) {
            System.out.print(", " + node.next.val);            
            node = node.next;
        }
        
        System.out.println();
        
    }

}

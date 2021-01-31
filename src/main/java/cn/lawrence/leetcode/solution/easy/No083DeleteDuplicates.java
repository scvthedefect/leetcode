package cn.lawrence.leetcode.solution.easy;

import cn.lawrence.leetcode.common.ListNode;

public class No083DeleteDuplicates {

    public static void main(String[] args) {
        test();
        test(1,2,3);
        test(1,1,2);
        test(1,1,1,1);
        
        test(1,2,2,2,2);
    }
    
    public static void test(int...vals) {
        ListNode node = new ListNode(vals);
        System.out.println("输入内容：");
        node.output();
        
        Solution083 s = new Solution083();
//        ListNode res = s.deleteDuplicates(node);
        ListNode res = s.deleteDuplicatesModified(node);
        System.out.println("输出内容");
        res.output();
        System.out.println();
    }
    
}

class Solution083 {
    
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }
        
        ListNode root = new ListNode(head.val);
        ListNode node = root;
        while(head.next != null) {
            if(head.next.val != head.val) {
                node.next = new ListNode(head.next.val);
                node = node.next;
            }
            
            head = head.next;
        }
        return root;
    }
    
    public ListNode deleteDuplicatesModified(ListNode head) {
        if(head == null) {
            return null;
        }
        
        ListNode current = head;
        while(current.next != null) {
            if(current.next.val != current.val) {
                current = current.next;
            } else {
                current.next = current.next.next;
            }
        }
        return head;
    }
    
}

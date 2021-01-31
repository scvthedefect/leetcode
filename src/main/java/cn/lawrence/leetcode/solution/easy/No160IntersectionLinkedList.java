package cn.lawrence.leetcode.solution.easy;

import cn.lawrence.leetcode.common.ListNode;

public class No160IntersectionLinkedList {

    public static void main(String[] args) {
        ListNode headA = new ListNode(0);
        ListNode a2 = new ListNode(9);
        headA.next = a2;
        ListNode a3 = new ListNode(1);
        a2.next = a3;
        ListNode a4 = new ListNode(2);
        a3.next = a4;
        ListNode a5 = new ListNode(4);
        a4.next = a5;
        
        ListNode headB = new ListNode(3);
        ListNode b2 = new ListNode(2);
        headB.next = b2;
        ListNode b3 = new ListNode(4);
        b2.next = b3;
//        headB.next = a4;
        
        headA.output();
        headB.output();
        
        Solution160 s = new Solution160();
        ListNode node = s.getIntersectionNode(headA, headB);
        System.out.println(node != null ? node.val : "null");
    }
    
}

class Solution160 {
    
    /**
     * 返回两链表相交的节点
     * 如果两个链表没有交点，返回null
     * 在返回结果后，两个链表仍须保持原有的结构。
     * 可假定整个链表结构中没有循环。
     * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
     *
     * e.g: headA=[4,1,8,4,5], headB=[5,0,1,8,4,5], intersaction=8 
     * 
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        
        ListNode pa = headA;
        ListNode pb = headB;
        while(pa != pb) {
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;
    }
    
}

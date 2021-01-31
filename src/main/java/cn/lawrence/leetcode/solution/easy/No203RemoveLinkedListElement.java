package cn.lawrence.leetcode.solution.easy;

import cn.lawrence.leetcode.common.ListNode;

/**
 * 删除链表中等于给定值 val 的所有节点。
 */
public class No203RemoveLinkedListElement {
    
    static No203RemoveLinkedListElement sample = new No203RemoveLinkedListElement();
    
    public static void main(String[] args) {
        test(6, 1,2,6,3,4,5,6);
        test(6, 6,1,2,6,3,4,5,6);
    }
    
    public static void test(int val, int...vals) {
        ListNode node = new ListNode(vals);
        node = sample.removeElements(node, val);
        node.output();
    }
    
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return head;
        }
        
        ListNode prev = head;
        ListNode node = prev.next;
        while(node != null) {
            ListNode tmp = node.next;
            if(node.val == val) {
                prev.next = tmp;
            } else {
                prev = node;
            }
            node = tmp;
        }
        while(head != null && head.val == val) { // 处理以val开头的节点
            head = head.next;
        }
        return head;
    }

}

package cn.lawrence.leetcode.solution.medium;

import java.util.ArrayList;
import java.util.List;

import cn.lawrence.leetcode.solution.easy.ListNode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
public class No019RemoveNthNode {
    
    static No019RemoveNthNode sample = new No019RemoveNthNode();
    public static void main(String[] args) {
        test(2, 1,2,3,4,5);
        test(1,1,2,3,4,5);
        test(5,1,2,3,4,5);
        test(1, 1);
    }
    
    static void test(int n, int...nums) {
        ListNode node = new ListNode(nums);
        node = sample.removeNthFromEnd(node, n);
        node.output();
    }
    
    /**
     * 
     * @param head
     * @param n 倒数的第n个节点
     * @return 
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while(node != null) {
            list.add(node);
            node = node.next;
        }
        int len = list.size();
        int targetIndex = len - n, prevIndex = targetIndex - 1, succIndex = targetIndex + 1;
        ListNode prev = prevIndex >= 0 && prevIndex < list.size() ? list.get(prevIndex) : null;
        ListNode succ = succIndex >= 0 && succIndex < list.size() ? list.get(succIndex) : null;
        
        list.get(targetIndex).next = null;
        if(prev != null) {
            prev.next = succ;
        }
        if(targetIndex == 0) {
            head = succ;
        }
        return head;
    }

}

package cn.lawrence.leetcode.solution.easy;

import cn.lawrence.leetcode.common.ListNode;

/**
 * 删除链表中的节点
 */
public class No237DeleteNodeInLinkedList {
    
    /**
     * 链表至少包含两个节点
     * 链表中所有节点的值都是唯一的。
     * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
     * @param node
     */
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}

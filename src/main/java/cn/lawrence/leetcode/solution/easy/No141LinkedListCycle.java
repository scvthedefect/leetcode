package cn.lawrence.leetcode.solution.easy;

import java.util.HashMap;

import cn.lawrence.leetcode.common.ListNode;

public class No141LinkedListCycle {
    
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode n1 = new ListNode(2);
        head.next = n1;
        
        ListNode n2 = new ListNode(0);
        n1.next = n2;
        
        ListNode n3 = new ListNode(-4);
        n2.next = n3;
        
        n3.next = n1;
        
        test(head, true);
    }

    public static void test(ListNode node, boolean expected) {
        Solution141 s = new Solution141();
//        boolean output = s.hasCycle(node);
//        boolean output = s.hasCycleModified(node);
        boolean output = s.hasCyclyOfficial(node);
        System.out.println(output == expected);
    }
    
}

class Solution141 {
    
    public boolean hasCyclyOfficial(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(slow != fast) {
            if(slow.next == null || fast.next == null) { // 环链会无限循环
                return false;
            }
            
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
    
    /**
     * 使用快慢指针，减少空间复杂度
     * @param head
     * @return
     */
    public boolean hasCycleModified(ListNode head) {
        ListNode slow = head, fast = head;
        int i = 0;
        while(fast != null) {
            if(i > 0 && i % 2 == 0) {
                slow = slow.next;
            }
            if(i > 0 && slow == fast) {
                return true;
            }
            fast = fast.next;
            i++;
        }
        return false;
    }
    
    /**
     * 使用 hashtable 记录遍历过的记录，空间复杂度较高
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        HashMap<ListNode, Integer> map = new HashMap<>();
        int pos = 0;
        
        ListNode prev = head;
        while(head != null) {
            if(map.containsKey(head)) {
                return true;
            }
            
            map.put(head, pos);
            head = head.next;
            
            prev.next = null;
            prev = head;
        }
        return false;
    }
    
}

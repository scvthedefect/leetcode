package cn.lawrence.leetcode.solution.hard;

import cn.lawrence.leetcode.solution.easy.ListNode;

public class No023MergeKSortedLists {
    
    public static void main(String[] args) {
        
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode node = null;
        ListNode current;
        int j;
        for(int i = 0; i < Integer.MAX_VALUE; i++) {
            current = lists[0];
            for(j = 1; j < lists.length; j++) {
                if(lists[j].val < current.val) {
                    current = lists[j];
                }
            }
            
            node = current;
        }
        return node;
    }

}

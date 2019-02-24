package cn.lawrence.leetcode.solution;

public class No021MergeTwoSortedLists {
    
    public static void main(String[] args) {
        // 负数、长度不一
        test(new ListNode(1,2,3,4), new ListNode(1,1,1,2));
        test(new ListNode(1,1,4), new ListNode(1,1,1,2));
        
        test(new ListNode(-1,0,4), new ListNode(1,1,1,2));
        test(new ListNode(-1,0,4), new ListNode(-99,-80, -1, 0, 1,2));
        
        test(new ListNode(1,2,3), new ListNode(1,1,4));
    }
    
    public static void test(ListNode l1, ListNode l2) {
        Solution021 s = new Solution021();
//        ListNode node = s.mergeTwoLists(l1, l2);
        ListNode node = s.mergeTwoListsModified(l1, l2);
        node.output();
    }

}

class Solution021 {
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = null;
        
        // 记录各链表当前的节点
        ListNode n1 = l1;
        ListNode n2 = l2;

        ListNode prev = null;
        while(n1 != null || n2 != null) { // 任一非空都可以继续
            ListNode node = null;
            if(n1 != null && n2 != null) {
                boolean isLess = n1.val < n2.val;
                if(isLess) {
                    node = n1;
                    n1 = n1.next;
                } else {
                    node = n2;
                    n2 = n2.next;
                }
                
            } else if (n1 != null) {
                node = n1;
                n1 = n1.next;
            } else {
                node = n2;
                n2 = n2.next;
            }
            
            if(root == null) {
                root = new ListNode(node.val);
                prev = root;
            } else {
                prev.next = new ListNode(node.val);
                prev = prev.next;
            }
        }
        return root;
    }
    
    /**
     * 优化版，直接使用对象引用，而非创建新对象
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsModified(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0); // 用于记录完整链表，为了代码整洁，可从无意义的root开始
        ListNode current = root;
        while(l1 != null && l2 != null) { // 任一链表已结束，即可退出循环
            if(l2 == null || l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        
        // 还未完成循环的部分，由于本身是有序的，因此直接拼接在链表后即可
        if(l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }
        
        return root.next;
    }
    
}
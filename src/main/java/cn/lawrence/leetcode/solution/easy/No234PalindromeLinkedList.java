package cn.lawrence.leetcode.solution.easy;

import java.util.Arrays;
import java.util.Stack;

public class No234PalindromeLinkedList {
    
    public static void main(String[] args) {
        test(true, 1,2,2,1);
//        test(false, 1,2);
    }
    
    public static void test(boolean expected, int...nums) {
        ListNode node = new ListNode(nums);
//        boolean result = isPalindrome(node);
        boolean result = isPalindromeV2(node);
        assert expected == result: String.format("unexpected result: %s", Arrays.toString(node.getRecords()));
    }
    
    /**
     * 验证链表是否为回文：1>2>2>1 true; 1>2 false;
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        ListNode n = head;
        Stack<Integer> s = new Stack<>();
        while(n != null) {
            s.add(n.val);
            n = n.next;
        }
        Integer[] arr = new Integer[s.size()];
        s.toArray(arr);
        for(int i = 0; i < arr.length / 2; i++) {
            if(arr[i].intValue() != arr[arr.length - i - 1].intValue()) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * 使用快慢指针，空间复杂度O(1)
     * @param head
     * @return
     */
    public static boolean isPalindromeV2(ListNode head) {
        ListNode fast = head, slow = head;
        
        // 找到中间节点
        int count = 0, position = 0;
        while(fast != null) {
            fast = fast.next;
            count++;
        }
        count /= 2;
        fast = head;
        while(++position <= count) {
            fast = fast.next;
        }
        
        // 反转下半段链表
        ListNode prev = null, temp = null;
        while(fast != null) {
            temp = fast.next;
            fast.next = prev;
            prev = fast;
            fast = temp;
        }
        fast = prev;
        while(fast != null) {
            if(fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

}

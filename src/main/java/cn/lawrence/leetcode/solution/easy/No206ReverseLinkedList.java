package cn.lawrence.leetcode.solution.easy;

public class No206ReverseLinkedList {
    
    public static void main(String[] args) {
        test(1,2,3,4,5);
        test(1,5,2,4,3);
    }
    
    public static void test(int...nums) {
        ListNode node = new ListNode(nums);
        node = reverseList(node);
        node.output();
    }
    
    public static ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null, temp = null;
        while(curr != null) {
            temp = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = temp;
        }
        return prev;
    }

}
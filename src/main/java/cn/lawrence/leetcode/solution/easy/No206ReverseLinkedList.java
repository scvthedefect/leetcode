package cn.lawrence.leetcode.solution.easy;

public class No206ReverseLinkedList {
    
    public static void main(String[] args) {
        test(1,2,3,4,5);
    }
    
    public static void test(int...nums) {
        ListNode node = new ListNode(nums);
        Solution206 s = new Solution206();
        node = s.reverseList(node);
        node.output();
    }

}

class Solution206 {
    
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = temp;
        }
        return prev;
        
        
//        Stack<ListNode> stack = new Stack<>();
//        while(head != null) {
//            stack.add(head);
//            head = head.next;
//        }
//        
//        if(stack.isEmpty()) {
//            return head;
//        }
//        
//        head = stack.pop();
//        ListNode node = head;
//        while(!stack.isEmpty()) {
//            node.next = stack.pop();
//            node = node.next;
//            node.next = null;
//        }
//        return head;
    }
    
}

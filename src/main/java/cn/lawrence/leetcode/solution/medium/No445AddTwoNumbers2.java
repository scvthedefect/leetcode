package cn.lawrence.leetcode.solution.medium;

import java.util.ArrayList;
import java.util.List;

import cn.lawrence.leetcode.solution.easy.ListNode;

/**
 * 两数相加
 * 除"0"外，其他数字均不会以0开头
 * 一个链表代表一个非负数，如(7->2->4->3)代表整数7243
 * 注意单个ListNode表示的整数范围可能超出int的范围
 */
public class No445AddTwoNumbers2 {
    
    static No445AddTwoNumbers2 sample = new No445AddTwoNumbers2();
    
    public static void main(String[] args) {
        case1();
        case2();
        case3();
        case4();
        case5();
        case6();
    }
    
    public static void case1() {
        // 7, 8, 0, 7
        ListNode l1 = new ListNode(7,2,4,3);
        ListNode l2 = new ListNode(5,6,4);
        ListNode node = sample.solutionV3(l1, l2);
        node.output();
    }
    
    public static void case2() {
        // 7, 2, 4, 3
        ListNode l1 = new ListNode(7,2,4,3);
        ListNode l2 = new ListNode(0);
        ListNode node = sample.solutionV3(l1, l2);
        node.output();
    }
    
    public static void case3() {
        // 7, 2, 4, 3
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(7,2,4,3);
        ListNode node = sample.solutionV3(l1, l2);
        node.output();
    }
    
    public static void case4() {
        // 1, 0
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        ListNode node = sample.solutionV3(l1, l2);
        node.output();
    }
    
    public static void case5() {
        // 0
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode node = sample.solutionV3(l1, l2);
        node.output();
    }
    
    public static void case6() {
        // 4, 0, 0, 0, 0, 0, 0, 0, 0, 6
        ListNode l1 = new ListNode(3,9,9,9,9,9,9,9,9,9);
        ListNode l2 = new ListNode(7);
        ListNode node = sample.solutionV3(l1, l2);
        node.output();
    }
    
    public ListNode solutionV3(ListNode l1, ListNode l2) {
        if(l1.val == 0 || l2.val == 0) {
            return l1.val == 0 ? l2 : l1;
        }
        List<Integer> ls1 = new ArrayList<>();
        while(l1 != null) {
            ls1.add(l1.val);
            l1 = l1.next;
        }
        List<Integer> ls2 = new ArrayList<>();
        while(l2 != null) {
            ls2.add(l2.val);
            l2 = l2.next;
        }
        List<Integer> lng = ls1.size() >= ls2.size() ? ls1 : ls2;
        List<Integer> shrt = lng == ls1 ? ls2 : ls1;
        
        ListNode node = null;
        boolean isCarry = false; // 是否进位
        int idxShrt = shrt.size() - 1;
        for(int i = lng.size() - 1; i >= 0; i--) { // 从后往前
            int val = lng.get(i) + (idxShrt >= 0 ? shrt.get(idxShrt) : 0) + (isCarry ? 1 : 0);
            val = (isCarry = val >= 10) ? val % 10 : val;
            ListNode tmp = new ListNode(val);
            if(node == null) {
                node = tmp;
            } else {
                tmp.next = node;
                node = tmp;
            }
            idxShrt--;
        }
        if(isCarry) { // 补充最高位进位
            ListNode tmp = new ListNode(1);
            tmp.next = node;
            node = tmp;
        }
        return node;
    }
    
    /**
     * 不修改链表结构，即不进行翻转
     * @param l1
     * @param l2
     * @return
     */
    @Deprecated // 无法处理过大整数
    public ListNode solutionV2(ListNode l1, ListNode l2) {
        if(l1.val == 0 || l2.val == 0) {
            return l1.val == 0 ? l2 : l1;
        }
        
        long sum1 = 0, sum2 = 0;
        while(l1 != null) {
            sum1 = (sum1 *= 10) + l1.val;
            l1 = l1.next;
        }
        while(l2 != null) {
            sum2 = (sum2 *= 10) + l2.val;
            l2 = l2.next;
        }
        sum1 += sum2;
        ListNode node = null;
        while(sum1 > 0) {
            int val = (int) sum1 % 10;
            ListNode tmp = new ListNode(val);
            if(node == null) {
                node = tmp;
            } else {
                tmp.next = node;
                node = tmp;
            }
            sum1 /= 10;
        }
        return node;
    }
    
    /**
     * 翻转链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode solutionV1(ListNode l1, ListNode l2) {
        if(l1.val == 0 || l2.val == 0) {
            return l1.val == 0 ? l2 : l1;
        }
        
        int len1 = 0;
        ListNode prev = null;
        while(l1 != null) {
            ListNode tmp = l1.next;
            l1.next = prev;
            prev = l1;
            l1 = tmp;
            len1++;
        }
        l1 = prev;
        int len2 = 0;
        prev = null;
        while(l2 != null) {
            ListNode tmp = l2.next;
            l2.next = prev;
            prev = l2;
            l2 = tmp;
            len2++;
        }
        l2 = prev;
        ListNode lng = len1 >= len2 ? l1 : l2;
        ListNode shrt = lng == l1 ? l2 : l1;
        
        ListNode node = lng;
        boolean isCarry = false; // 是否进位
        while(lng != null) {
            int val1 = lng.val;
            int val2 = shrt != null ? shrt.val : 0;
            int res = val1 + val2 + (isCarry ? 1 : 0);
            res = (isCarry = res >= 10) ? res % 10 : res;
            lng.val = res;
            
            lng = lng.next;
            shrt = shrt != null ? shrt.next : null;
        }
        
        prev = null;
        while(node != null) {
            ListNode tmp = node.next;
            node.next = prev;
            prev = node;
            node = tmp;
        }
        node = prev;
        if(isCarry) { // 补充最高位进一
            ListNode tmp = new ListNode(1);
            tmp.next = node;
            node = tmp;
        }
        return node;
    }

}

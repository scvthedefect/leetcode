package cn.lawrence.leetcode.solution.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class No496NextGreaterElem {
    
    public static void main(String[] args) {
        int[] n1 = {4,1,2};
        int[] n2 = {1,3,4,2};
        test(n1, n2);
        
        int[] n3 = {2,4};
        int[] n4 = {1,2,3,4};
        test(n3, n4);
    }
    
    static No496NextGreaterElem sample = new No496NextGreaterElem();
    static void test(int[] nums1, int[] nums2) {
//        int[] result = sample.nextGreaterElement(nums1, nums2);
        int[] result = sample.nextGreaterElementB(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
    
    public int[] nextGreaterElementB(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < nums2.length; i++) {
            while(!stack.isEmpty() && nums2[i] > stack.peek()) { // 栈中可能有多个元素剩余
                map.put(stack.pop(), nums2[i]);
            }
            
            stack.add(nums2[i]);
        }
        while(!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }
        int[] res = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
    
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(); // num - index
        for(int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        
        int[] res = new int[nums1.length];
        int start, end = nums2.length - 1;
        int index = 0;
        Integer key;
        for(int i = 0; i < nums1.length; i++) {
            key = Integer.valueOf(nums1[i]);
            start = map.get(key).intValue();
            index = getIndex(nums2, nums1[i], start + 1, end);
            res[i] = index == -1 ? -1 : nums2[index];
        }
        return res;
    }
    
    private int getIndex(int[] nums, int target, int left, int right) {
        if(left >= right) {
            if(left >= nums.length) {
                return -1;
            }
            return nums[left] > target ? left : -1;
        }
        
        int mid = left + (right - left) / 2;
        int n1 = getIndex(nums, target, left, mid);
        int n2 = getIndex(nums, target, mid + 1, right);
        if(n1 == -1 && n2 == -1) {
            return -1;
        }
        if(n1 == -1 || n2 == -1) {
            return n1 == -1 ? n2 : n1;
        }
        return Math.min(n1, n2);
    }

}

package cn.lawrence.leetcode.solution.easy;

import cn.lawrence.leetcode.utils.ArrayUtil;

public class No088MergeSortedArray {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }
    
//    public static void main(String[] args) {
//        int[] nums1 = {2,3,4,0,0,0};
//        int m = 3;
//        
//        int[] nums2 = {1,2,3};
//        int n = 3;
//        
//        Solution088 s = new Solution088();
//        s.merge(nums1, m, nums2, n);
//        
//        ArrayUtil.printArr(nums1);
//    }
    
    public static void test1() {
        Solution088 s = new Solution088();
        int[] nums1 = {1,3,0};
        int m = 2;
        int[] nums2 = {2};
        int n = 1;
        s.merge(nums1, m, nums2, n);
        ArrayUtil.printArr(nums1);
    }
    
    public static void test2() {
        Solution088 s = new Solution088();
        int[] nums1 = {2,3,0};
        int m = 2;
        int[] nums2 = {1};
        int n = 1;
        s.merge(nums1, m, nums2, n);
        ArrayUtil.printArr(nums1);
    }
    
    public static void test3() {
        Solution088 s = new Solution088();
        int[] nums1 = {1,2,0};
        int m = 2;
        int[] nums2 = {3};
        int n = 1;
        s.merge(nums1, m, nums2, n);
        ArrayUtil.printArr(nums1);
    }
    
    public static void test4() {
        Solution088 s = new Solution088();
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;
        s.merge(nums1, m, nums2, n);
        ArrayUtil.printArr(nums1);
    }
    
}

class Solution088 {
    
    /**
     * 合并两个排序数组
     * @param nums1 
     * @param m nums1有效元素的长度
     * @param nums2
     * @param n nums2有效元素的长度，m+n为nums1的长度
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n < 1) {
            return;
        }
        
        int i1 = 0;
        int i2 = 0;
        while(m < nums1.length) {
            int val1 = nums1[i1];
            int val2 = nums2[i2];
            
            boolean isInsert = val2 <= val1 || i1 > m - 1;
            if(isInsert) {
                for(int i = m; i > i1; i--) {
                    nums1[i] = nums1[i - 1];
                }
                nums1[i1] = val2;
                
                i2++;
                m++;
            }
            
            i1++;
        }
    }
    
    public void move(int[] nums, int m) {
        for(int i = m; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
    }
}

package cn.lawrence.leetcode.solution.easy;

import cn.lawrence.leetcode.utils.ArrayUtil;

public class No035SearchInsertPosition {

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, 3};
        test(1, 0, arr);
        test(5, 7, arr);
        test(0, -2, arr);
        
        test(1, 2, 1,3);
    }
    
    public static void test(int expected, int target, int...nums) {
        Solution035 s = new Solution035();
        int index = s.searchInsert(nums, target);
        
        ArrayUtil.printArr(nums);
        
        boolean isExpected = expected == index;
        System.out.println(String.format("[target num: %d], [expected: %d], [output: %d], [is expected: %b]", 
                target, expected, index, isExpected));
    }
    
}

class Solution035 {
    
//    public int searchInsert(int[] nums, int target) {
//        if(nums == null || nums.length == 0) {
//            return 0;
//        }
//        
//        int pos = 0;
//        for(; pos < nums.length; pos++) {
//            if(nums[pos] >= target) {
//                break;
//            }
//        }
//        return pos;
//    }
    
    public int searchInsert(int[] nums, int target) {
        int index = -1;
        if(nums == null || nums.length == 0) {
            return index;
        }
        
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        int val = 0;
        boolean isMatch = false;
        boolean isRight = false;
        while(left <= right) {
            isRight = false;
            mid = left + (right - left) / 2;
            val = nums[mid];
            
            
            if(target == val) {
                isMatch = true;
                break;
            } else if (target < val) {
                right = mid - 1;
            } else {
                isRight = true;
                left = mid + 1;
            }
        }
        return isMatch || !isRight ? mid : mid + 1;
    }
}


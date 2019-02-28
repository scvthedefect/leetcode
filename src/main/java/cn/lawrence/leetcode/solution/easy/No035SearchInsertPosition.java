package cn.lawrence.leetcode.solution.easy;

import cn.lawrence.leetcode.utils.ArrayUtil;

public class No035SearchInsertPosition {

    public static void main(String[] args) {
        test(1, 0, -1,0,1,2,3);
        test(4, 7, 0,1,2,3);
    }
    
    public static void test(int expected, int target, int...nums) {
        Solution035 s = new Solution035();
        int index = s.searchInsert(nums, target);
        boolean isExpected = expected == index;
        ArrayUtil.printArr(nums);
        System.out.println(String.format("Is expected: %b", isExpected));
        
        // TODO 二分法改进
    }
    
}

class Solution035 {
    
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int pos = 0;
        for(; pos < nums.length; pos++) {
            if(nums[pos] >= target) {
                break;
            }
        }
        return pos;
    }
}


package cn.lawrence.leetcode.solution.easy;

import java.util.Arrays;

public class No167TwoSum {
    
    public static void main(String[] args) {
        Solution167 s = new Solution167();
        
//        int[] nums = {2, 7, 11, 15};
//        int target = 9;
        int[] nums = {1,2,3,4,4,9,56,90};
        int target = 8;
        
        int[] result = s.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
        
        
    }

}

class Solution167 {
    
    public int[] twoSum(int[] numbers, int target) {
        int i1 = 0, i2 = 0, t = -1;
        for(int i = 0; i < numbers.length; i++) {
            int another = target - numbers[i];
            t = binSearch(numbers, another);
            if(t != -1 && t != i) {
                i1 = i + 1;
                i2 = t + 1;
                break;
            }
        }
        
        int index1 = i1 < i2 ? i1 : i2;
        int index2 = i1 < i2 ? i2 : i1;
        int[] result = {index1, index2};
        return result;
    }
    
    public int binSearch(int[] nums, int target) {
        int index = -1;
        if(nums == null || nums.length == 0) {
            return index;
        }
        
        int i = 0, j = nums.length - 1, mid = 0;
        while(i <= j) {
            mid = i + (j - i) / 2;
            if(target < nums[mid]) {
                j = mid - 1;
            } else if(target > nums[mid]) {
                i = mid + 1;
            } else {
                index = mid;
                break;
            }
        }
        return index;
    }
    
}
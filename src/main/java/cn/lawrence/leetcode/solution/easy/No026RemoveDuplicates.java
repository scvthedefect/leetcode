package cn.lawrence.leetcode.solution.easy;

import cn.lawrence.leetcode.utils.ArrayUtil;

public class No026RemoveDuplicates {

    public static void main(String[] args) {
        test();
        test(1);
        test(1,1);
        test(1,1,1);
        test(1,1,2);
        
        test(1,1,2,3);
        test(1,2,3,4);
        
        test(1,1,1,1,2,2,2,3);
    }
    
    public static void test(int...nums) {
//        Solution026 s = new Solution026();
//        int count = s.removeDuplicates(nums);
        
//        Solution026V2 s = new Solution026V2();
//        int count = s.removeDuplicates(nums);
        
        Solution026V3 s = new Solution026V3();
        int count = s.removeDuplicates(nums);
        
        ArrayUtil.printArr(nums);
        System.out.println(String.format("output count: %d", count));
        
    }
    
}

class Solution026 {
    
    public int removeDuplicates(int[] nums) {
        if(nums == null) {
            return 0;
        }
        
        if(nums.length == 1) {
            return 1;
        }
        
        int index = 0;
        for(; index < nums.length - 1; index++) {
            int cur = nums[index];
            int next = nums[index + 1];
            if(cur == next) {
                moveElement(index, nums);
                index--;
            } else if(cur > next) {
                break;
            }
        }
        
        return index + 1;
    }
    
    public void moveElement(int index, int[] nums) {
        int num = nums[index];
        for(; index < nums.length - 1; index++) {
            nums[index] = nums[index + 1];
        }
        
        nums[index] = num - 1;
    }
}

class Solution026V2{
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        if(nums.length == 1) {
            return 1;
        }
        
        int len = nums.length;
        int max = nums[len - 1]; // 整个数组最大值
        int cycleMax = nums[0]; // 当前最大值
        
        for(int i = 1; i < len; i++) {
            int cur = nums[i];
            cycleMax = cur > cycleMax ? cur : cycleMax; // 记录当前最大值
            int prev = nums[i - 1];
            
            boolean skip = cur > prev;
            if(!skip) {
                swapValue(i, cycleMax, nums);
                cycleMax = nums[i];
            }
            
            if(cycleMax == max) {
                break;
            }
        }
        
        int count = 0;
        for(int i = 0; i < len; i++) {
            if(nums[i] == max) {
                count = i + 1;
                break;
            }
        }
        return count;
    }
    
    public boolean swapValue(int begin, int standard, int[] nums) {
        int j = begin;
        for(; j < nums.length; j++) {
            int newVal = nums[j];
            if(newVal > standard) {
                // 与后面第一个比当前基准更大的数进行交换
                nums[j] = nums[begin];
                nums[begin] = newVal;
                return true;
            }
        }
        return false;
    }
    
}

class Solution026V3 {
    
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
//        if(nums.length == 1) {
//            return 1;
//        }
        
        int i = 0;
        for(int j = 1; j < nums.length; j++) {
            if(nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
    
}

package cn.lawrence.leetcode.solution;

import cn.lawrence.leetcode.utils.ArrayUtil;

public class No027RemoveElements {
    
    public static void main(String[] args) {
        test(0);
        
        int[] arr = {};
        test(0, arr);
        
        test(0, 0,1);
        test(0, 0,0,1);
        
        test(0, 0,1,1,0);
        test(0, 1,0,0,2,2,0,0,3,4);
        
        test(0, 0,0,0,1,0,0,0,1);
    }
    
    public static void test(int val, int...nums) {
//        Solution027 s = new Solution027();
        Solution027V2 s = new Solution027V2();
        int count = s.removeElement(nums, val);
        ArrayUtil.printArr(nums);
        System.out.println(String.format("count: %d", count));
    }

}

class Solution027 {
    
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) { // 注（坑）：无需考虑count后数组的内容，即无需把之后的值设为val
                nums[count] = nums[i];
                if(i != count) {                    
                    nums[i] = val;
                }
                count++;
            }
        }
        return count;
    }
    
}

class Solution027V2 {
    
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        for(int j = 0; j < nums.length; j++) {
            if(nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
    
}
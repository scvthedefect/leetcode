package cn.lawrence.leetcode.solution.easy;

import java.util.Arrays;

public class No053MaxSubArray {
    
    public static void main(String[] args) {
//        test(6, -2,1,-3,4,-1,2,1,-5,4);
//        test(-1, -2, -1);
//        test(-1, -1, -2);
//        test(3, 1, 2);
//        test(1, -2, 1);
        
        test(2, 0, -3, 1, 1);
    }
    
    public static void test(int expect, int...nums) {
        Solution053 s = new Solution053();
        int result = s.maxSubArray(nums);
        System.out.println(String.format("输入：%s, 期望结果：%d, result: %d. As expected: %b", 
                Arrays.toString(nums), expect, result, (expect == result)));
    }

}

class Solution053 {
    
    public int solution(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        
        return -1;
    }
    
    public int solve(int[] nums, int left, int right) {
        if(left >= right) {
            return nums[left];
        }
        
        return -1;
    }
    
    @Deprecated
    public int maxSubArray(int[] nums) {
        int i = 0, len = nums.length;
        int[] temp = new int[len];
        System.arraycopy(nums, 0, temp, 0, len);
        
        for(i = 1; i < len; i++) {
            temp[i] += temp[i - 1];
        }
        boolean hasPst = false;
        int maxIndex = 0, maxTemp = 0;
        for(i = 0; i < len; i++) { // 第一次遍历，获取数组升降趋势
            if(nums[i] > 0) {
                hasPst = true;
            }
            if(temp[i] > temp[maxIndex]) {
                maxIndex = i;
            }
            
            if(nums[i] > nums[maxTemp]) {
                maxTemp = i;
            }
        }
        
        if(!hasPst || maxIndex < 1) {
            return nums[maxTemp];
        }
        
        System.arraycopy(nums, 0, temp, 0, maxIndex + 1);
        for(i = maxIndex - 1; i >= 0; i--) {
            temp[i] += temp[i + 1];
        }
        
        int minIndex = 0;
        for(i = 0; i <= maxIndex; i++) {
            if(temp[i] > temp[minIndex]) {
                minIndex = i;
            }
        }
        
        int result = 0;
        for(i = minIndex; i <= maxIndex; i++) {
            result += nums[i];
        }
        return result;
    }
    
}

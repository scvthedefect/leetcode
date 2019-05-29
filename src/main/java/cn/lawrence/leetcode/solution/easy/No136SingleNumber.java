package cn.lawrence.leetcode.solution.easy;

public class No136SingleNumber {
    
    public static void main(String[] args) {
        test(9,9);
        test(1,1,2,2);
        test(4,4,1,2,1,2);
        
        test(3, 1,3,1);
        test(3, 4,1,4,3,1);
        test(1, 4,1,4,3,1);
    }
    
    public static void test(int expect, int...nums) {
        Solution136 s = new Solution136();
        int output = s.singleNumber(nums);
        System.out.println(expect == output);
    }

}

class Solution136 {
    
    /**
     * 不使用额外空间、线性时间复杂度
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int result = nums[0];
        if(nums.length <= 1) {
            return result;
        }
        
        for(int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
    
}

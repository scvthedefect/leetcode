package cn.lawrence.leetcode.solution.easy;

import java.util.Arrays;

public class No198HouseRobber {
    
    public static void main(String[] args) {
        test(1,2,3,1);
        test(2,7,9,3,1);
    }
    
    public static void test(int...nums) {
        Solution198 s = new Solution198();
        int result = s.rob(nums);
        System.out.println(String.format("input: %s, result: %d", Arrays.toString(nums), result));
    }

}

class Solution198 {
    
    public int rob(int[] nums) {
        throw new UnsupportedOperationException(); // TODO 
    }
    
}

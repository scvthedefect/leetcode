package cn.lawrence.leetcode.solution.easy;

import java.util.Arrays;

public class No283MoveZeros {

    public static void main(String[] args) {
        test(0,1,0,3,12);
        test(1,2,0,3,0,4);
    }
    
    public static void test(int...nums) {
        System.out.println(String.format("input: %s", Arrays.toString(nums)));
        
        Solution283 s = new Solution283();
//        s.moveZeros(nums);
        s.moveZerosModified(nums);
        
        System.out.println(String.format("ouput: %s", Arrays.toString(nums)));
        System.out.println("================================");

        // input: 0,0,0,1,2,3,4,5,6,7
        // 1st: 1,0,0,0,2,3,4,5,6,7
        // 2nd: 1,2,0,0,0,3,4,5,6,7
        // 3rd: 1,2,3,0,0,0,4,5,6,7
        // 4th: 1,2,3,4,0,0,0,5,6,7
        // 5th: 1,2,3,4,5,0,0,0,6,7
        // 6th: 1,2,3,4,5,6,0,0,0,7
        // 7th: 1,2,3,4,5,6,7,0,0,0
        // O(n^2)
        // 分治策略？
    }
    
}

class Solution283 {
    
    public void moveZerosV2(int[] nums) {
        
        int mid = nums.length / 2;
        
    }
    
    public void doMove(int[] nums, int head, int tail) {
        if(head >= tail) {
            return;
        }
        
        
    }
    
    public void moveZerosModified(int[] nums) {
        int n = nums.length - 1; // 从后往前遍历
//        for(int i = 0; i < nums.length; i++) {
        for(int i = 0; i < n; i++) {
            if(nums[i] != 0) {
                continue;
            }
            
            // 此时，nums[i] == 0
            for(; n != i; n--) { // nums[n]找到非零位置
                if(nums[n] != 0) {
                    nums[i] ^= nums[n];
                    nums[n] ^= nums[i];
                    nums[i] ^= nums[n];
                    break;
                }
            }
        }
    }
    
    public void moveZeros(int[] nums) {
        int temp;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                continue;
            }
            
            // 此时nums[i]==0, 找出下一个不为0的索引，并进行交换
            for(temp = i + 1; temp < nums.length; temp++) {
                if(nums[temp] != 0) {
                    nums[i] ^= nums[temp];
                    nums[temp] ^= nums[i];
                    nums[i] ^= nums[temp];
                    break;
                }
                
                if(temp == nums.length - 1) {
                    return;
                }
            }
        }
    }
    
}

package cn.lawrence.leetcode.solution;

import cn.lawrence.leetcode.utils.ArrayUtil;

public class No066PlusOne {

    public static void main(String[] args) {
        test(9);
        test(1,9);
        test(1,0,2,4);
        test(1,2,3,4);
        test(9,9,9,9);
    }
    
    public static void test(int...digits) {
        System.out.println("输入：");
        ArrayUtil.printArr(digits);
        
        Solution66 solution = new Solution66();
        digits = solution.plusOne(digits);
        
        System.out.println("输出：");
        ArrayUtil.printArr(digits);
    }
    
}

class Solution66 {
    
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int lastIndex = len - 1;
        boolean isPlus = false; // 是否需要进一
        boolean isOverflow = false; // 是否溢出
        for(int i = lastIndex; i >= 0; i--) {
            int val = i == lastIndex ? digits[i] + 1 : digits[i];
            if(isPlus) {
                val += 1;
            }
            
            int mod = val % 10;
            if(val != mod) {
                isPlus = true;
                val = mod;
            } else {
                isPlus = false;
            }
            digits[i] = val;
            
            if(!isPlus) {
                break;
            }
            
            isOverflow = i == 0 && isPlus;
        }
        
        if(isOverflow) {
            int[] arr = new int[len + 1];
            arr[0] = 1;
            System.arraycopy(digits, 0, arr, 1, len);
            digits = arr;
        }
        
        return digits;
    }
    
}

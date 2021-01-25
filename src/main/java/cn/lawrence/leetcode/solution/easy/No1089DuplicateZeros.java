package cn.lawrence.leetcode.solution.easy;

import java.util.Arrays;

public class No1089DuplicateZeros {
    
    static No1089DuplicateZeros sample = new No1089DuplicateZeros();
    
    public static void main(String[] args) {
        test(1,0,2,3,0,4,5,0); // 1,0,0,2,3,0,0,4
//        test(0,1,0,2,3,0,4,5); // 0,0,1,0,0,2,3,0
//        test(1,2,3); // 1,2,3
//        test(0,0,0);
    }
    
    public static void test(int...arr) {
        System.out.println(String.format("input: %s", Arrays.toString(arr)));
//        sample.duplicateZeroes(arr);
        sample.duplicateZeroesV2(arr);
        System.out.println(String.format("output: %s", Arrays.toString(arr)));
    }
    
    public void duplicateZeroesV2(int[] arr) {
        if(arr == null || arr.length == 0) {
            return;
        }
        
        int i = 0, zeroCount = 0;
        int start = -1; // 第一个非零值的索引，用于判断是否需要移位操作
        for(i = 0; i < arr.length - 1; i++) {
            if(arr[i] == 0) {
                zeroCount++;
            } else if(start == -1) {
                start = i;
            }
        }
        System.out.println(String.format("zeroCount: %d", zeroCount));
        if(start == -1) {
            return;
        }
        i = arr.length - 1;
        while(zeroCount > 0) {
//            int prev = arr.length - zeroCount - 1;
            int prev = i - zeroCount;
            while(i >= prev) {
                arr[i] = arr[i - zeroCount];
                i--;
            }
            System.out.println(String.format("looping zeroCount=%d, prev=%d", zeroCount, prev));
            zeroCount--;
        }
        
//        while(zeroCount > 0) {
//            if(arr[i] != 0) {
//                arr[i] = arr[i - zeroCount];                
//            }
//            zeroCount--;
//            i--;
//        }
    }
    
    public void duplicateZeroes(int[] arr) {
        if(arr == null || arr.length == 0) {
            return;
        }
        
        int j = 0;
        for(int i = 0; i < arr.length - 1; i++) { // 最后一位不影响结果
            if(arr[i] != 0) {
                continue;
            }
            
            for(j = arr.length - 1; j > i; j--) {
                arr[j] = arr[j - 1];
            }
            i++;
        }
    }

}

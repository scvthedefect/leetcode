package cn.lawrence.leetcode.utils;

public class ArrayUtil {
    
    public static void printArr(String desc, int[] nums) {        
        System.out.print(String.format("%s [", desc));
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            int num = nums[i];
            System.out.print(num);
            if(i != len - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println();
    }
    
    public static void printArr(int[] nums) {
        printArr("", nums);
    }

}

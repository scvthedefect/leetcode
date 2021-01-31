package cn.lawrence.leetcode.solution.easy;

import java.util.Arrays;

public class Solution1502 {
    
    public static void main(String[] args) {
        Solution1502 solution = new Solution1502();
//        int[] arr = {3,5,1};
        int[] arr = {1,2,4};
        boolean flag = solution.canMakeArithmeticProgression(arr);
        System.out.println(flag);
    }
    
    /**
     * 已知条件：
     * 2 <= arr.length <= 1000
     * -10^6 <= arr[i] <= 10^6
     * @param arr
     * @return
     */
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        int tmp;
        for (int i = 2; i < arr.length; i++) {
            tmp = (arr[i] - arr[i - 1]);
            if (tmp != diff) {
                return false;
            }
        }
        return true;
    }

}

package cn.lawrence.leetcode.solution.easy;

public class No231PowerOfTwo {

    public static void main(String[] args) {
        test(1);
        test(2);
        test(32);
        test(1<<30);
    }
    
    public static void test(int n) {
        Solution231 s = new Solution231();
        boolean flag = s.isPowerOfTwo(n);
        System.out.println(String.format("input: %d, result: %b", n, flag));
    }
    
}

class Solution231 {
    
    public boolean isPowerOfTwo(int n) {
        // 能否通过1的有限次右移得到n
        int temp = 1;
        for(int i = 0; i < 31; i++) {
            if(temp << i == n) {
                return true;
            } else if(temp > n) {
                break;
            }
        }
        return false;
    }
    
}

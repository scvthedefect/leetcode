package cn.lawrence.leetcode.solution.easy;

public class No231PowerOfTwo {

    public static void main(String[] args) {
        test(-Integer.MAX_VALUE);
        test(0);
        test(1);
        test(2);
        test(32);
        test(1<<30);
    }
    
    public static void test(int n) {
        boolean flag = isPowerOfTwo(n);
        System.out.println(String.format("input: %d, result: %b", n, flag));
    }
    
    /**
     * 判断是否为2的幂（除位移外的解法）：判断是否仅有一个"1"
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n) {
        if(n < 1) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
    
}
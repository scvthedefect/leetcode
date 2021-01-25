package cn.lawrence.leetcode.solution.easy;

public class No342PowerOf4 {
    
    public static void main(String[] args) {
        test(1, true);
        test(5, false);
        test(16, true);
        test(32, false);
        test(Integer.MAX_VALUE, false);
    }
    
    public static void test(int num, boolean expected) {
//        boolean result = isPowerOfFour(num);
        boolean result = isPowerOfFourV2(num);
        assert result == expected: String.format("input=%d, result=%b unexpected.", num, result);
    }
    
    /**
     * 判断输入的整数是否为4的幂次方
     * @param n 32位有符号整数
     * @return
     */
    public static boolean isPowerOfFour(int num) {
        if(num <= 0) {
            return false;
        }
        // 4^n等价于2^2n，故该问题为位操作类问题
        int n = 0, pow = 1 << 2 * n;
        while(pow < num && n < 15) { // 此类循环要判断是否会发生溢出
            pow = 1 << 2 * ++n;
        }
        return pow == num;
    }
    
    /**
     * 不使用循环或递归完成
     * @param num
     * @return
     */
    public static boolean isPowerOfFourV2(int num) {
        // 判断两个条件: 1. 仅有1个1，如0100, 0001等; 2. 1是位于奇数位上
        if(num <= 0) {
            return false;
        }
        
        if((num & (num - 1)) != 0) {
            return false;
        }
        if((num & 0x55555555) == 0) {
            return false;
        }
        return true;
    }

}

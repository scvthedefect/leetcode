package cn.lawrence.leetcode.solution.easy;

public class No069Sqrtx {
    
    public static void main(String[] args) {
        test(1);
        test(4);
        test(9);
        test(8);
        test(16);
        test(25);
        test(32);
        
        test(900);
        test(125348);
    }
    
    public static void test(int x) {
        int result = mySqrt(x);
        System.out.println(String.format("input=%d, sqrt=%d", x, result));
    }
    
    /**
     * 牛顿法开平方
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        if(x == 1) {
            return 1;
        }
        
        double sqrt = x / 2;
        int prev = 0;
        while((int) sqrt != prev) {
            prev = (int) sqrt;
            sqrt = (sqrt + x / sqrt) / 2;
        }
        return (int) sqrt;
    }

}

package cn.lawrence.leetcode.solution.easy;

public class No070ClimbingStairs {
    
    public static void main(String[] args) {
        test(1, 1);
        test(2, 2);
        test(3, 3);
        test(4, 5);
        
        test(50, 0);
    }
    
//    public static void test(int n, int result) {
//        Solution070 s = new Solution070();
//        int res = s.climbStairs(n);
//        boolean match = res == result;
//        System.out.println(String.format("n=%d, expect=%d, result=%d, match=%b", n, result, res, match));
//    }
    
    public static void test(int n, int out) {
        long start = System.currentTimeMillis();
        Solution070 s = new Solution070();
        int res = s.climbStairs(n);
//        System.out.println(res);
//        System.out.println(String.format("耗时：%d", (System.currentTimeMillis() - start)));
        System.out.println(String.format("input: %d, output: %d, expected: %b, 耗时: %d ms.", 
                n, out, (res == out), (System.currentTimeMillis() - start)));
    }

}

class Solution070 {
    
//    public int climbStairs(int n) {
//        if(n < 1) {
//            return 0;
//        }
//        if(n == 1) {
//            return 1;
//        }
//        if(n == 2) {
//            return 2;
//        }
//        return climbStairs(n - 1) + climbStairs(n - 2);
//    }
    
    public int climbStairs(int n) {
        if(n <= 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        
        int f = 0, g = 1;
        while(n-- > 0) {
            g = g + f;
            f = g - f;
        }
        return g;
    }
    
}

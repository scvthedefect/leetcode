package cn.lawrence.leetcode.solution.easy;

public class No326PowerOfThree {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        test(1, true);
        test(3, true);
        test(5, false);
        test(6, false);
        test(8, false);
        test(9, true);
        test(27, true);
        test(28, false);
        test(29, false);
        test(30, false);
        test(31, false);
        test(32, false);
        test(33, false);
        test(Integer.MAX_VALUE, false); // 不能使用连乘，因为会溢出
        
        long end = System.currentTimeMillis();
        System.out.println(String.format("耗时: %d ms.", (end - start)));
        
    }
    
    public static void test(int n, boolean expect) {
        No326PowerOfThree s = new No326PowerOfThree();
        boolean flag = s.isPowerOfThree(n);
        System.out.println(String.format("input: %d, result: %b, as expected: %b", n, flag, (flag == expect)));
    }
    
    /**
     * 持续除以3
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        while(n > 0) {
            if(n % 3 == 0) {
                n /= 3;
            } else {
                return false;
            }
        }
        return n == 1;
    }
    
}

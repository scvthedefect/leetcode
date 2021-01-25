package cn.lawrence.leetcode.solution.easy;

public class No367ValidPerfectSquare {
    
    public static void main(String[] args) {
        test(1, true);
        test(2, false);
        test(3, false);
        test(4, true);
        test(16, true);
        test(20, false);
        test(49, true);
        
        test(10000, true);
        test(1000_000, true);
        test(Integer.MAX_VALUE, false);
        
    }
    
    public static void test(int num, boolean expected) {
        No367ValidPerfectSquare s = new No367ValidPerfectSquare();
        boolean flag = s.newTonMethod(num);
        assert flag == expected: String.format("input=%d, flag=%b", num, flag);
    }
    
    /**
     * 牛顿法开平方
     * @param num
     * @return
     */
    public boolean newTonMethod(int num) {
        if(num == 1) {
            return true;
        }
        
        long r = num;
        long sum = 0;
        while((sum = r * r) > num) {
            r = (r + num / r) / 2;
//            System.out.println(String.format("sum=%d, r=%d", sum, r));
        }
        
        if(sum == num) {
            return true;
        }
        return false;
    }
    
}

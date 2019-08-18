package cn.lawrence.leetcode.solution.easy;

/**
 * 第n个泰波那契数
 */
public class No1137Tribonacci {
    
    static No1137Tribonacci FUN = new No1137Tribonacci();
    
    public static void main(String[] args) {
        test(0, 0);
        test(1, 1);
        test(2, 1);
        test(3, 2);
        test(4, 4);
        test(5, 7);
        test(25, 1389537);
    }
    
    public static void test(int i, int expected) {
        int num = FUN.tribonacci(i);
        assert num == expected: String.format("n=%d, fun(i) expected: %d, but got %d", i, expected, num);
    }
    
    /**
     * 数轴上将a从i=0移动到i=n的位置
     * @param n
     * @return
     */
    public int tribonacci(int n) {
        int a = 0, b = 1, c = 1;
        while(n-- > 0) { // 一共需要循环n次
            c = a + b + c; // c右移一位
            b = c - a - b; // b右移一位
            a = c - a - b; // a右移一位
        }
        return a;
    }

}

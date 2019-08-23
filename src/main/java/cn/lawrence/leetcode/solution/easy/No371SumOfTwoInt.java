package cn.lawrence.leetcode.solution.easy;

public class No371SumOfTwoInt {
    
    static No371SumOfTwoInt sample = new No371SumOfTwoInt();
    
    public static void main(String[] args) {
        test(3, 5);
        test(3, -5);
        test(11, 13);
    }
    
    public static void test(int a, int b) {
        int res = sample.getSum(a, b);
        System.out.println(String.format("%d+%d=%d", a, b, res));
    }
    
    public int getSum(int a, int b) {
        int carry = 0;
        while(b != 0) {
            carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }

}

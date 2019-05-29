package cn.lawrence.leetcode.solution.easy;

public class No191NumberOf1Bits {
    
    public static void main(String[] args) {
        test(11);
        test(1<<7);
        test(Integer.MAX_VALUE);
        test(-1);
        test(Integer.MIN_VALUE);
    }
    
    public static void test(int n) {
        Solution191 s = new Solution191();
        int res = s.hammingWeight(n);
        String str = Integer.toBinaryString(n);
        System.out.println(String.format("input: %d (%s), count: %d", n, str, res));
    }

}

class Solution191 {
    
    public int hammingWeight(int n) {
        int c = 0;
        while(n != 0) {
            c = (n & 0x1) == 1 ? ++c : c;
//            if((n & 0x1) == 1) {
//                c++;
//            }
            n >>>= 1;
        }
        return c;
    }
    
}

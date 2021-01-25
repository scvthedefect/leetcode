package cn.lawrence.leetcode.solution.easy;

public class No172TrailingZeros {
    
    public static void main(String[] args) {
//        test(1);
//        test(2);
//        test(3);
//        test(4);
//        test(5);
//        test(6);
//        test(7);
//        test(8);
//        test(9);
//        test(10);
//        test(11);
//        test(12);
        test(13); // overflow
        test(30);
        test(75);
    }
    
    public static void test(int n) {
        Solution172 s = new Solution172();
        int count = s.trailingZeros(n);
        System.out.println(String.format("count: %d", count));
        System.out.println("=====================");
    }

}

class Solution172 {
    
    public int trailingZeros(int n) {
        // 1-9中只有2和5两个因子的乘积为10，其中5的数量要少得多，因此只需要统计5的因子数量
        // n 可能包含多个5，如25=1*5*5, 50=2*5*5等等
        int count = 0;
        while(n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
    
    /**
     * 不能使用该方法，整数会溢出
     * @param n
     * @return
     */
    public int template(int n) {
        // factorial
        int result = 1;
        for(int i = 1; i <= n; i++) {
            result *= i;
        }
        
        int count = 0;
        while(result % 10 == 0) {
            count++;
            result /= 10;
        }
        return count;
    }
    
}

package cn.lawrence.leetcode.solution.easy;

public class No264UglyNumber2 {
    
    public static void main(String[] args) {
        test(1, 1);
        test(4, 4);
        test(5, 5);
        test(10, 12);
        test(1690, 2123366400);
    }
    
    public static void test(int n, int expected) {
        No264UglyNumber2 solution = new No264UglyNumber2();
        int result = solution.nthUglyNumber2(n);
        assert result == expected: String.format("input=%d, result=%d unexpected", n, result);
    }
    
    public int nthUglyNumber2(int n) {
        if(n <= 0) {
            return 0;
        }
        
        int[] arr = new int[n];
        arr[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0, min = 0;
        for(int i = 1; i < n; i++) {
            min = Math.min(2 * arr[i2], Math.min(3 * arr[i3], 5 * arr[i5]));
            if(min == 2 * arr[i2]) i2++;
            if(min == 3 * arr[i3]) i3++;
            if(min == 5 * arr[i5]) i5++;
            arr[i] = min;
        }
        return arr[n - 1];
    }
    
}

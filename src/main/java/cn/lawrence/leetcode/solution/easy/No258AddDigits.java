package cn.lawrence.leetcode.solution.easy;

public class No258AddDigits {
    
    public static void main(String[] args) {
        test(0, 0);
        test(28, 1);
        test(38, 2);
        test(Integer.MAX_VALUE, 1);
    }
    
    public static void test(int input, int expect) {
        No258AddDigits s = new No258AddDigits();
//        int result = s.addDigits(input);
        int result = s.addDigitsModified(input);
        assert result == expect : String.format("n: %d, result: %d", input, result);
    }
    
    public int addDigitsModified(int num) {
        if(num < 10) {
            return num;
        }
        
        num %= 9;
        num = num == 0 ? 9 : num;
        return num;
    }
    
    /**
     * 
     * @param n 非负整数
     * @return
     */
    public int addDigits(int num) {
        if(num < 10) {
            return num;
        }
        
        int result = 0, mod = 0;
        while(num > 0) {
            mod = num % 10;
            num /= 10;
            result += mod;
        }
        return addDigits(result);
    }

}

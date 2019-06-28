package cn.lawrence.leetcode.solution.easy;

public class No263UglyNumber {
    
    public static void main(String[] args) {
        test(-2147483648, false);
        test(0, false);
        test(1, true);
        test(6, true);
        test(7, false);
        test(8, true);
        test(10, true);
        test(14, false);
        test(Integer.MAX_VALUE, false);
    }
    
    public static void test(int num, boolean expected) {
        No263UglyNumber solution = new No263UglyNumber();
        boolean flag = solution.isUgly(num);
        assert flag == expected: String.format("num=%d, unexpected=%b", num, flag);
    }
    
    public int nthUgly(int n) {
        int count = 0, index = 1;
        boolean isUgly = false;
        while(index <= n) {
            isUgly = isUgly(index);
            if(isUgly) {
                count++;
            }
            index++;
        }
        return count;
    }
    
    /**
     * 判断是否为丑数，1为丑数
     * @param num 输入范围同int
     * @return
     */
    public boolean isUgly(int num) {
        if(num <= 0) {
            return false;
        }
        if(num == 1) {
            return true;
        }
        
        while(num > 1) {
            if(num % 5 == 0) {
                num /= 5;
                continue;
            }
            if(num % 3 == 0) {
                num /= 3;
                continue;
            }
            if(num % 2 == 0) {
                num /= 2;
                continue;
            }
            
            return false;
        }
        return true;
    }

}

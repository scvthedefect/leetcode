package cn.lawrence.leetcode.solution.easy;

public class No171ExcelSheetColumnNumber {

    public static void main(String[] args) {
        test("A", 1);
        test("B", 2);
        test("C", 3);
        test("Z", 26);
        
        test("AA", 27);
        test("AB", 28);
        test("AZ", 52);
        
        test("ZY", 701);
    }
    
    public static void test(String str, int expected) {
        Solution171 s = new Solution171();
        
//        int result = s.titleToNumber(str);
        int result = s.titleToNumberModified(str);
        
        assert (result == expected) : String.format("input: %s, expected: %d, but got: %d.", 
                str, expected, result);
    }
    
}

class Solution171 {
    
    public int titleToNumberModified(String s) {
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            result = result * 26 + s.charAt(i) - 64;
        }
        return result;
    }
    
    /**
     * 本质是数字的进制转换：26进制转为10进制（连乘法）
     * @param s
     * @return
     */
    public int titleToNumber(String s) {
        int result = 0, radix = 26, len = s.length(), i = len - 1, pow = 0;
        char c = 0;
        while(i >= 0) {
            pow = len - i - 1;
            c = (char) (s.charAt(i) - 64);
            result += c * Math.pow(radix, pow);
            i--;
        }
        return result;
    }
    
}

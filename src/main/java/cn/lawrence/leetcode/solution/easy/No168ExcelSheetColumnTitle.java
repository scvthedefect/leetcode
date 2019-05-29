package cn.lawrence.leetcode.solution.easy;

public class No168ExcelSheetColumnTitle {
    
    public static void main(String[] args) {
        test(1, "A");
        test(2, "B");
        test(3, "C");
        test(26, "Z");
        
        test(27, "AA");
        test(28, "AB");
        test(52, "AZ");
        
        test(701, "ZY");
        test(1500, "BER");
        test(Integer.MAX_VALUE, null);
        System.out.println("fine.");
    }
    
    public static void test(int n, String expect) {
        Solution168 s = new Solution168();
        String str = s.convertToTitle(n);
        
        boolean flag = expect == null ? true : str.equals(expect);
        assert (flag) : String.format("unexpected result: n=%d, expected=%s, but converted=%s", 
                n, expect, str);
    }

}

class Solution168 {
    
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        int mod = 0, radix = 26;
        boolean last = false;
        
        while(n > 0) {
            mod = n % radix;
            n /= radix;
            last = mod == 0;
            if(last) {
                mod = radix;
                n--;
            }
            sb.append((char) (65 + mod - 1));
        }
        return sb.reverse().toString();
    }
    
//    public String convertToTitle(int n) {
//        // 1. 确定数位
//        int digitCount = 0, radix = 26;
//        int num = n;
//        do {
//            digitCount++;
//            num /= radix + 1;
//        } while(num > 0);
//        
//        // 2. 连除法确定每个数位
//        char[] digits = new char[digitCount];
//        int mod = 0, i = digitCount - 1;
//        do {
//            mod = n % radix;
//            mod = mod == 0 ? radix : mod;
//            n /= radix;
//            digits[i--] = (char) (65 + mod - 1);
//        } while(i >= 0);
//        return new String(digits);
//    }
    
}
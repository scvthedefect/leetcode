package cn.lawrence.leetcode.solution.easy;

/**
 * 字符串的最大公因子
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 */
public class No1071GreatestCommonDivisorOfStrings {
    
    static No1071GreatestCommonDivisorOfStrings sample = new No1071GreatestCommonDivisorOfStrings();
    
    public static void main(String[] args) {
        test("ABCABC", "ABC", "ABC");
        test("ABABAB", "ABAB", "AB");
        test("LEET", "CODE", "");
    }
    
    public static void test(String str1, String str2, String expected) {
        String res = sample.gcdOfStrings(str1, str2);
        assert res.equals(expected): String.format("s1: %s, s2: %s, expected: %s, but got: %s", 
                str1, str2, expected, res);
    }
    
    /**
     * 辗转相除法求最大公因子: (a, b) = gcd(b, a mod b); 大数对小数取模
     * 字符串S能被T除尽的定义：S=T+...+T，即S=n*T
     * 故str1与str2有公因子T，则str1=n1*T; str2=n2*T; str1+str2=n1*T+n2*T=(n1+n2)*T=str2+str1
     * @param str1
     * @param str2
     * @return
     */
    public String gcdOfStrings(String str1, String str2) {
        if(!str1.concat(str2).equals(str2.concat(str1))) {
            return "";
        }
        
        String lng = str1.length() >= str2.length() ? str1 : str2;
        String shrt = lng == str1 ? str2 : str1;
        int a = lng.length();
        int b = shrt.length();
        int mod = 0;
        while(b != 0) {
            mod = a % b;
            a = b;
            b = mod;
        }
        return lng.substring(0, a);
    }

}

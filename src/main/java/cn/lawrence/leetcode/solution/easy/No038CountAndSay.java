package cn.lawrence.leetcode.solution.easy;

public class No038CountAndSay {
    
    public static void main(String[] args) {
        test(-1, "");
        test(0, "");
        test(1, "1");
        test(2, "11");
        test(3, "21");
        test(4, "1211");
        test(5, "111221");
        test(6, "312211");
        test(7, "13112221");
    }
    
    public static void test(int n, String expectedStr) {
        Solution038 s = new Solution038();
        String str = s.countAndSay(n);
//        System.out.println(str);
        boolean matched = expectedStr.equals(str);
        System.out.println(String.format("n: %d; expected: %s; matched: %b", n, expectedStr, matched));
    }

}


class Solution038 {
    
    public String countAndSay(int n) {
        if(n == 1) {
            return "1";
        }
        
        if(n < 1 || n > 30) {
            return "";
        }
        
        String str = countAndSay(n - 1); // 以上一次的结果作为本次解析的内容
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < str.length()) {
            char c = str.charAt(i);
            i++;
            int charCount = 1;
            
            for(; i < str.length(); i++) {
                if(str.charAt(i) != c) {
                    break;
                }
                charCount++;
            }
            sb.append(charCount).append(c);
        }
        return sb.toString();
    }
    
}

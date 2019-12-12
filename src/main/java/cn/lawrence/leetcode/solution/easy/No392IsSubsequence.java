package cn.lawrence.leetcode.solution.easy;

public class No392IsSubsequence {
    
    public static void main(String[] args) {
        test("abc", "ahbgdc", true);
        test("axc", "ahbgdc", false);
    }
    
    static No392IsSubsequence sample = new No392IsSubsequence();
    public static void test(String s, String t, boolean expected) {
        boolean result = sample.isSubsequence(s, t);
        System.out.println(String.format("as expected: %b", (result == expected)));
    }
    
    /**
     * 验证s是否为t的子序列
     * s和t中仅包含英文小写字母
     * @param s max(length(s)) = 100
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0 && t.length() == 0) {
            return true;
        }
        
        int is = 0;
        int it = 0;
        char cs, ct;
        while(is < s.length() && it < t.length()) {
            cs = s.charAt(is);
            ct = t.charAt(it);
            if(cs == ct) {
                is++;
                it++;
            } else {
                it++;
            }
        }
        return is == s.length();
    }

}

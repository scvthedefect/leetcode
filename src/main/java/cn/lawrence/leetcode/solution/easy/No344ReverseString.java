package cn.lawrence.leetcode.solution.easy;

public class No344ReverseString {

    public static void main(String[] args) {
        test("apple");
        test("orange");
    }
    
    public static void test(String str) {        
        char[] r = str.toCharArray();
        Solution344 s = new Solution344();
        s.reverseString(r);
        System.out.println(r);
    }
    
}

class Solution344 {
    
    public void reverseString(char[] s) {
        int len = s.length;
        for(int i = 0; i < len / 2; i++) {
            s[i] ^= s[len - i - 1];
            s[len - i - 1] ^= s[i];
            s[i] ^= s[len - i - 1];
        }
    }
    
}

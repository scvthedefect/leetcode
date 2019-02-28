package cn.lawrence.leetcode.solution.easy;

public class No058LengthOfLastWord {

    public static void main(String[] args) {
        test("h", 1);
        test("apple", 5);
        test("hello world", 5);
        test("hi world ", 5);
        test(" bigFish ", 7);
    }
    
    public static void test(String str, int len) {
        Solution58 s = new Solution58();
        int length = s.lengthOfLastWord(str);
        System.out.println(String.format("input: %s; match: %b", str, length == len));
    }
    
}

class Solution58 {
    
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        int len = s.length();
        int lastIndex = -1;
        int secLastIndex = -1;
        for(int i = len -1; i>= 0; i--) {
            if(lastIndex == -1 && s.charAt(i) != ' ') {
                lastIndex = i;
            }
            
            if(secLastIndex == -1 && lastIndex != -1 && s.charAt(i) == ' ') {
                secLastIndex = i;
            }
            
            if(lastIndex != -1 && secLastIndex > 0) {
                break;
            }
        }
        return lastIndex - secLastIndex;
    }
    
}

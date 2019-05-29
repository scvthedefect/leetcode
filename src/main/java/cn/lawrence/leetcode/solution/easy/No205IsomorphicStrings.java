package cn.lawrence.leetcode.solution.easy;

import java.util.HashMap;
import java.util.Map;

public class No205IsomorphicStrings {
    
    public static void main(String[] args) {
        test("add", "egg", true);
        test("paper", "title", true);
//        test("a", "b", true);
        test("abc", "add", false);
        test("bluen", "green", false);
    }
    
    public static void test(String s, String t, boolean expected) {
        Solution205 solution = new Solution205();
//        boolean flag = solution.isIsomorphic(s, t);
        boolean flag = solution.isIsomorphicV2(s, t);
        System.out.println(String.format("%s vs %s, \tresult: %b, \tas expected: %b", 
                s, t, flag, (flag == expected)));
    }

}

class Solution205 {
    
    public boolean isIsomorphicV2(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                if(map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                if(map.containsValue(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
    
    public boolean isIsomorphic(String s, String t) {
        int len = s.length();
        char[] arr = new char[len];
        int diff = 0, j = 0;
        for(int i = 0; i < len; i++) {
            if(arr[i] > 0) {
                continue;
            }
            
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            diff = c1 - c2;
            for(j = i; j < len; j++) {
                if(s.charAt(j) == c1 || t.charAt(j) == c2) {
                    int temp = s.charAt(j) - t.charAt(j);
                    if(temp != diff) {
                        return false;
                    }
                    arr[j] = s.charAt(j);
                }
            }
        }
        return true;
    }
    
}

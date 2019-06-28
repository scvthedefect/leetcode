package cn.lawrence.leetcode.solution.easy;

import java.util.HashMap;
import java.util.Map;

public class No290WordPattern {
    
    public static void main(String[] args) {
        test("abba", "dog cat cat dog", true);
        test("abba", "dog cat cat fish", false);
        test("aaaa", "dog cat cat dog", false);
        test("abba", "dog dog dog dog", false);
        
        test("aaa", "aa aa aa aa", false);
    }
    
    public static void test(String pattern, String str, boolean expected) {
        No290WordPattern s = new No290WordPattern();
        boolean flag = s.wordPattern(pattern, str);
        assert flag == expected: String.format("pattern: %s, word: %s, expected: %b", pattern, str, expected);
    }

    /**
     * @param pattern 假设只包含小写字母
     * @param str 包含了由空格分割的小写字母
     * @return
     */
    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");
        if(pattern.length() != arr.length) {
            return false;
        }
        
        boolean flag = true;
        Map<Character, String> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            Character c = Character.valueOf(pattern.charAt(i));
            String s = arr[i];
            
            if(map.containsKey(c)) {
                String value = map.get(c);
                if(value.equals(s)) {
                    continue;
                }
                return false;
            } else {
                if(map.containsValue(s)) { // 已经有value, 但是没有对应的key, 说明key-value不匹配
                    return false;
                }
                map.put(c, s);
            }
        }
        return flag;
    }
    
}

package cn.lawrence.leetcode.solution.easy;

import java.util.HashMap;
import java.util.Map;

public class No387FirstUniqueChar {

    static No387FirstUniqueChar sample = new No387FirstUniqueChar();
    public static void main(String[] args) {
        test("leetcode", 0);
        test("loveleetcode", 2);
        test("aabbccddee", -1);
        test("", -1);
    }
    
    public static void test(String s, int expected) {
        int index = sample.firstUniqChar(s);
        System.out.println(String.format("input: %s, as expected: %b", s, (index == expected)));
    }
    
    /**
     * 字符串中的第一个唯一字符
     * 可以假定该字符串只包含小写字母。
     * @param s
     * @return 首个唯一字符的索引值，不存在则为-1
     */
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0) {
            return -1;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        Character k;
        Integer v;
        for(int i = 0; i < s.length(); i++) {
            k = Character.valueOf(s.charAt(i));
            if((v = map.get(k)) != null) {
                map.put(k, v + 1);
            } else {
                map.put(k, 1);
            }
        }
        for(int i = 0; i < s.length(); i++) {
            k = Character.valueOf(s.charAt(i));
            if((v = map.get(k)) != null && v == 1) {
                return i;
            }
        }
        return -1;
    }
    
}

package cn.lawrence.leetcode.solution.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词 
 */
public class No242ValidAnagram {
    
    static No242ValidAnagram sample = new No242ValidAnagram();
    
    public static void main(String[] args) {
        test("anagram", "nagaram", true);
        test("rat", "car", false);
        test("", "", true);
    }
    
    public static void test(String s, String t, boolean expected) {
//        boolean result = sample.isAnagram(s, t);
        boolean result = sample.solution2(s, t);
        assert result == expected: String.format("unexpected: %s, %s", s, t);
    }
    
    /**
     * 用哈希表的形式存储（支持unicode）
     * @param s
     * @param t
     * @return
     */
    public boolean solution2(String s, String t) {
        if(s.length() == 0 && t.length() == 0) {
            return true;
        }
        if(s.length() != t.length()) {
            return false;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for(Character c : s.toCharArray()) {
            Integer count = map.get(c);
            if(count == null) {
                map.put(c, 1);
            } else {
                map.put(c, count + 1);
            }
        }
        for(Character c : t.toCharArray()) {
            Integer count = map.get(c);
            if(count == null) {
                return false;
            }
            if(--count == 0) {
                map.remove(c);
            } else {
                map.put(c, count);
            }
        }
        return map.isEmpty();
        
    }
    
    public boolean isAnagram(String s, String t) {
        if(s.length() == 0 || t.length() == 0) {
            return true;
        }
        if(s.length() != t.length()) {
            return false;
        }

        // 可以用 Arrays.sort() 代替
        char[] sArr = countingSort(s.toCharArray());
        char[] tArr = countingSort(t.toCharArray());
        for(int i = 0; i < s.length(); i++) {
            if(sArr[i] != tArr[i]) {
                return false;
            }
        }
        return true;
    }
    
    public char[] countingSort(char[] chs) {
        int i = 0, min = chs[0], max = chs[0];
        for(i = 1; i < chs.length; i++) {
            if(chs[i] < min) {
                min = chs[i];
            }
            if(chs[i] > max) {
                max = chs[i];
            }
        }
        char[] c = new char[max - min + 1];
        for(i = 0; i < chs.length; i++) {
            c[chs[i] - min]++;
        }
        for(i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }
        char[] arr = new char[chs.length];
        for(i = 0; i < chs.length; i++) {
            arr[--c[chs[i] - min]] = chs[i];
        }
        return arr;
    }

}

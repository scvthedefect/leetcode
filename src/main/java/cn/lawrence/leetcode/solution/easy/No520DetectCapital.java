package cn.lawrence.leetcode.solution.easy;

public class No520DetectCapital {
    
    public static void main(String[] args) {
        test("USA");
        test("FlaG");
    }
    
    public static void test(String word) {
        Solution520 s = new Solution520();
        boolean flag = s.detectCapitalUse(word);
        System.out.println(String.format("input: %s, result: %b", word, flag));
    }

}

class Solution520 {
    
    public boolean detectCapitalUse(String word) {
        // 1. 全大写
        // 2. 全小写
        // 3. 仅首字母大写
        
//        int hash = word.hashCode();
//        if(word.toUpperCase().hashCode() == hash || word.toLowerCase().hashCode() == hash) {
//            return true;
//        }
//        
//        char c = 0;
//        for(int i = 1; i < word.length(); i++) {
//            c = word.charAt(i);
//            if(c >= 'A' && c <= 'Z') {
//                return false;
//            }
//        }
//        return true;
        
        int capCount = 0; // 记录大写字母出现的次数
        char c = word.charAt(0);
        boolean isCapFst = c >= 'A' && c <= 'Z';
        capCount = isCapFst ? ++capCount : capCount;
        
        for(int i = 1; i < word.length(); i++) {
            c = word.charAt(i);
            if(c >= 'A' && c <= 'Z') {
                capCount++;
            }
        }
        return capCount == 0 || capCount == word.length() || (isCapFst && capCount == 1);
    }
    
}

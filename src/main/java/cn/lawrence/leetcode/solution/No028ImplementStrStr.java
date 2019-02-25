package cn.lawrence.leetcode.solution;

public class No028ImplementStrStr {
    
    public static void main(String[] args) {
        test("", "", 0);
        test(null, null, -1);
        
        test("apple", "e", 4);
        test("apple", "le", 3);
        test("apple", "apple", 0);
        
        test("apple", "apple123", -1);
        
//        Solution028 s = new Solution028();
//        int index = s.strStr("", "");
//        System.out.println(index);
        
    }
    
    public static void test(String haystack, String needle, int expect) {
        Solution028 s = new Solution028();
        int index = s.strStr(haystack, needle);
        boolean expected = index == expect;
        System.out.println(String.format("haystack: %s; needle: %s; index: %d; As expected: %b", 
                haystack, needle, index, expected));
    }

}

class Solution028 {
    
//    public int strStr(String haystack, String needle) {
//        if(haystack == null || needle == null) {
//            return -1;
//        }
//        
//        if(needle == "") {
//            return 0;
//        }
//        
//        int needleLen = needle.length();
//        int hsLen = haystack.length() - needleLen + 1;
//        if(hsLen < 1) {
//            return -1;
//        }
//        
//        for(int i = 0; i < hsLen; i++) {
//            for(int j = 0; j < needleLen; j++) {
//                if(haystack.charAt(i + j) != needle.charAt(j)) {
//                    i += j;
//                    break;
//                }
//                
//                if(j + 1 == needleLen) {
//                    return i;
//                }
//            }
//        }
//        return -1;
//    }
    
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null) {
            return -1;
        }
        
        return haystack.indexOf(needle);
    }
    
}

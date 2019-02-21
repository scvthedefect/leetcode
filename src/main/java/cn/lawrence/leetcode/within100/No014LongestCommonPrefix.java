package cn.lawrence.leetcode.within100;

/**
 * 最长公共前缀
 */
public class No014LongestCommonPrefix {

    public static void main(String[] args) {
        test("", "test", "apple", "te");
        test("ap", "append", "apple", "apt");
        test("org", "orgcom", "orgte", "orgss");
        test("org", "org");
        
        test("", "org", "");
        
    }
    
    public static void test(String expected, String...strs) {
        solution014 s = new solution014();
        String prefix = s.longestCommonPrefix(strs);
        
        boolean isMatch = expected.equals(prefix);
        System.out.println(String.format("Common prefix: %s, match expected: %b", prefix, isMatch));
    }
    
}

class solution014 {
    
    /**
     * 所有输入只包含小写字母 a-z
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        if(strs == null || strs.length == 0) {
            return prefix;
        }
        
        if(strs.length == 1) {
            return strs[0];
        }
        
        // 以最短的字符串为标准
        int index = 0;
        String standard = strs[index];
        int stdl = standard.length();
        for(int i = 1; i < strs.length; i++) {
            String str = strs[i];
            int len = str.length();
            if(len < stdl) {
                standard = str;
                stdl = len;
                index = i;
            }
        }
        
        int endIndex = 0;
        for(int i = 0; i < standard.length(); i++) {
            char c = standard.charAt(i);
            boolean isMatch = true;
            
            for(int j = 0; j < strs.length; j++) {
                if(j == index) {
                    continue;
                }
                if(strs[j].charAt(i) != c) {
                    isMatch = false;
                    break;
                }
            }
            
            if(isMatch) {
                endIndex++;
            } else {
                break;
            }
        }
        return endIndex > 0 ? standard.substring(0, endIndex) : prefix;
    }
    
}

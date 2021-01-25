package cn.lawrence.leetcode.solution.easy;

/**
 * 反转字符串中的元音 
 */
public class No345ReverseVowels {
    
    public static void main(String[] args) {
        test("", "");
        test("hello", "holle");
        test("leetcode", "leotcede");
        test("Aa", "aA");
        test(".,", ".,");
        test(" apG0i4maAs::sA0m4i0Gp0", " ipG0A4mAas::si0m4a0Gp0");
        
        
        // 输入 "apG0i4maAs::sA0m4i0Gp0"
        // 预期 "ipG0A4mAas::si0m4a0Gp0"
    }
    
    public static void test(String s, String expected) {
        No345ReverseVowels solution = new No345ReverseVowels();
        String result = solution.reverseVowelsV2(s);
//        System.out.println(String.format("input=\"%s\", output=\"%s\"", s, result));
        assert expected.equals(result): String.format("input: \"%s\", expected: \"%s\", but got: \"%s\"", s, expected, result);
    }
    
    public String reverseVowelsV2(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        char[] c = s.toCharArray();
        int len = c.length, i = 0, j = len - 1;
        while(i < j) {
            while(i < len && !isVowel(c[i])) {
                i++;
            }
            while(j >= 0 && !isVowel(c[j])) {
                j--;
            }
            
            if(i < j) {
                c[i] ^= c[j];
                c[j] ^= c[i];
                c[i] ^= c[j];
                
                i++;
                j--;
            } else {
                i++;
            }
        }
        return new String(c);
    }
    
    @Deprecated
    public String reverseVowels(String s) {
        char[] c = s.toCharArray();
        int i = 0, j = s.length() - 1;
        boolean f1 = false, f2 = false; // i/j处字符是否为元音
        int i1 = 0, i2 = 0;
        while(i < j) {
            if(!f1) {
                f1 = isVowel(c[i++]);
            }
            if(!f2) {
                f2 = isVowel(c[j--]);
            }
            
            if(f1 && f2) {
                i1 = i - 1;
                i2 = j + 1;
                if(c[i1] != c[i2] && Math.abs(c[i1] - c[i2]) != 32) {
                    c[i1] ^= c[i2];
                    c[i2] ^= c[i1];
                    c[i1] ^= c[i2];
                }
                
                f1 = false;
                f2 = false;
            }
        }
        return new String(c);
    }
    
    public boolean isVowel(char c) {
        switch (c) {
        case 'a':
        case 'A':
        case 'e':
        case 'E':
        case 'i':
        case 'I':
        case 'o':
        case 'O':
        case 'u':
        case 'U':
            return true;
        default:
            return false;
        }
    }

}

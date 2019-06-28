package cn.lawrence.leetcode.solution.easy;

public class No125ValidPalindrome {
    
    public static void main(String[] args) {
        test("A man, a plan, a canal: Panama", true);
        test("race a car", false);
        test("", true);
    }
    
    public static void test(String s, boolean expected) {
        No125ValidPalindrome solution = new No125ValidPalindrome();
//        boolean flag = solution.isPalindrome(s);
        boolean flag = solution.isPalindromeModified(s);
        assert flag == expected : String.format("input: %s, result: %b", s, flag);
    }
    
    /**
     * 用头尾指针一次遍历
     * @param s
     * @return
     */
    public boolean isPalindromeModified(String s) {
        if(s == "") {
            return true;
        }
        
        int i = 0, j = s.length() - 1;
        while(i < j) {
            char ci = s.charAt(i);
            boolean isCheck = (ci >= '0' && ci <= '9') || (ci >= 'a' && ci <= 'z') || (ci >= 'A' && ci <= 'Z');
            if(!isCheck) {
                i++;
                continue;
            }
            
            char cj = s.charAt(j);
            isCheck = (cj >= '0' && cj <= '9') || (cj >= 'a' && cj <= 'z') || (cj >= 'A' && cj <= 'Z');
            if(!isCheck) {
                j--;
                continue;
            }
            
            ci = (char) (ci >= 'A' && ci <= 'Z' ? ci + 32 : ci);
            cj = (char) (cj >= 'A' && cj <= 'Z' ? cj + 32 : cj);
            if(ci != cj) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    public boolean isPalindrome(String s) {
        if(s == "") {
            return true;
        }
        
        s = s.toLowerCase(); // 转为小写方便后续处理
        StringBuilder sb = new StringBuilder();
        int i = 0, len = s.length();
        for(i = 0; i < len; i++) {
            char c = s.charAt(i);
            if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                sb.append(c);
            }
        }
        
        len = sb.length();
        for(i = 0; i < len / 2; i++) {
            int j = len - i - 1; 
            char c1 = sb.charAt(i);
            char c2 = sb.charAt(j);
            if(c1 != c2) {
                return false;
            }
        }
        return true;
    }

}

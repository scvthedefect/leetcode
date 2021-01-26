package cn.lawrence.leetcode.solution.easy;

public class Solution1021 {
    
    public static void main(String[] args) {
        Solution1021 solution = new Solution1021();
//        String S = "(()())(())";
//        String S = "";
//        String S = "(()())(())(()(()))";
        String S = "()()";
        String str = solution.removeOuterParentheses(S);
        System.out.println(str);
    }
    
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        String str;
        int count = 0;
        int i = 0, j = 0;
        char c;
        
        while (i < S.length()) {
            c = S.charAt(i);
            if (c == '(') {
                count++;
            } else {
                count--;
            }
            
            if (count == 0) {
                str = S.substring(j + 1, i);
                sb.append(str);
                j = i + 1;
            }
            i++;
        }
        return sb.toString();
    }

}

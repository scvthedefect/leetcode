package cn.lawrence.leetcode.solution.easy;

public class No541ReverseString2 {
    
    public static void main(String[] args) {
        test("abcdefg", 2, "bacdfeg");
        test("", 2, "");
    }
    
    private static No541ReverseString2 sample = new No541ReverseString2();
    public static void test(String s, int k, String expected) {
        String result = sample.reverseString(s, k);
        System.out.println(String.format("s: %s, k: %d, result: %s, as expected: %b",
                s, k, result, (expected.equals(result))));
    }
    
    public String reverseString(String s, int k) {
        int counter = 1, left = 0, right = k; // left included, right excluded.
        int i;
        StringBuilder sb = new StringBuilder();
        while(left < s.length()) {
            if(right > s.length()) {
                right = s.length();
            }
            
            if(counter++ % 2 == 1) { // 需要进行翻转
                for(i = right - 1; i >= left; i--) {
                    sb.append(s.charAt(i));
                }
            } else { // 无需翻转
                for(i = left; i < right; i++) {
                    sb.append(s.charAt(i));
                }
            }
            left += k;
            right += k;
        }
        return sb.toString();
    }
}

package cn.lawrence.leetcode.solution.easy;

/**
 * 字符串整数相加
 */
public class No415AddStrings {
    
    static No415AddStrings sample = new No415AddStrings();
    
    public static void main(String[] args) {
        test("1", "1", "2");
        test("999", "1", "1000");
        test("0", "999", "999");
    }
    
    public static void test(String num1, String num2, String expect) {
        String result = sample.addStrings(num1, num2);
        System.out.println(expect.equals(result));
    }
    
    public String addStrings(String num1, String num2) {
        if(num1.length() == 0 || num2.length() == 0) {
            return num1.length() == 0 ? num2 : num1;
        }
        
        StringBuilder sb = new StringBuilder();
        boolean isCarry = false;
        int i = num1.length() - 1, j = num2.length() - 1;
        int c1 = 0, c2 = 0, sum = 0;
        while(i >= 0 && j >= 0) {
            c1 = num1.charAt(i--) - 48;
            c2 = num2.charAt(j--) - 48;
            sum = c1 + c2 + (isCarry ? 1 : 0);
            sum = (isCarry = sum >= 10) ? sum % 10 : sum;
            sb.append(sum);
        }
        while(i >= 0) {
            sum = (num1.charAt(i--) - 48) + (isCarry ? 1 : 0);
            sum = (isCarry = sum >= 10) ? sum % 10 : sum;
            sb.append(sum);
        }
        while(j >= 0) {
            sum = (num2.charAt(j--) - 48) + (isCarry ? 1 : 0);
            sum = (isCarry = sum >= 10) ? sum % 10 : sum;
            sb.append(sum);
        }
        if(isCarry) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

}

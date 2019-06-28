package cn.lawrence.leetcode.solution.easy;

public class No504Base7 {
    
    public static void main(String[] args) {
        test(100);
        test(-7);
        
        test(0);
        test(10000000);
        test(-10000000);
    }
    
    public static void test(int num) {
        String res = convertToBase7(num);
        System.out.println(String.format("input=%d, output=%s", num, res));
    }

    /**
     * 转换为七进制数
     * @param num 输入范围为[1e-7, 1e7]
     * @return
     */
    public static String convertToBase7(int num) {
        if(num == 0) {
            return "0";
        }
        boolean isNegative = num < 0;
        num = isNegative ? -num : num;
        StringBuilder sb = new StringBuilder();
        // 连除法
        int mod = 0;
        while(num != 0) {
            mod = num % 7;
            sb.append(mod);
            num /= 7;
        }
        
        if(isNegative) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }
    
}

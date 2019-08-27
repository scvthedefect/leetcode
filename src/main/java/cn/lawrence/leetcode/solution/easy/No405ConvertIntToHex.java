package cn.lawrence.leetcode.solution.easy;

/**
 * 将整数转换为十六进制
 */
public class No405ConvertIntToHex {

    static No405ConvertIntToHex sample = new No405ConvertIntToHex();
    
    public static void main(String[] args) {
        test(0, "0");
        test(15, "f");
        test(26, "1a");
        test(Integer.MAX_VALUE, "7fffffff");
        
        test(-1, "ffffffff");
        test(-2, "fffffffe");
    }
    
    public static void test(int num, String expected) {
        String result = sample.toHex(num);
        System.out.println(String.format("num: %d, result: %s, as expected: %b", 
                num, result, (expected.equals(result))));
    }
    
    
    
    /**
     * 转换为十六进制数
     * @param num 负数则用补码形式表示
     * @return
     */
    public String toHex(int num) {
        if(num == 0) {
            return "0";
        }
        
        char[] digits = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        StringBuilder sb = new StringBuilder(8);
        int mod = 0;
        do {
            mod = num & 0b1111;
            num = num >>> 4;
            sb.append(digits[mod]);
        } while(num != 0);
        return sb.reverse().toString();
    }
    
}

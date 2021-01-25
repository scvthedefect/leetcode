package cn.lawrence.leetcode.solution.easy;

/**
 * 数字的补数
 */
public class No476NumberComplement {
    
    static No476NumberComplement sample = new No476NumberComplement();
    
    public static void main(String[] args) {
        test(5, 2);
        test(1, 0);
        test(0, 0);
    }
    
    public static void test(int num, int expect) {
//        int res = sample.findComplement(num);
        int res = sample.findComplementV2(num);
        System.out.println(String.format("input: %d, result: %d, expect: %d, %b", 
                num, res, expect, res == expect));
    }
    
    /**
     * 返回输入整数的补数，即二进制取反
     * @param num 正整数
     * @return
     */
    public int findComplement(int num) {
        if(num <= 0) {
            return 0;
        }
        
        StringBuilder sb = new StringBuilder();
        int tmp = num;
        while(tmp > 0) {
            int n = tmp & 1 ^ 1;
            sb.append(n);
            
            tmp >>= 1;
        }
        return Integer.valueOf(sb.reverse().toString(), 2);
    }
    
    public int findComplementV2(int num) {
        if(num <= 0) {
            return 0;
        }
        
        int res = 0, tmp = 1;
        while(tmp <= num) {
            int n = num & tmp;
            tmp <<= 1;
        }
        return res;
    }

}

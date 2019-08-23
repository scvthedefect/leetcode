package cn.lawrence.leetcode.solution.easy;

/**
 * 给定两个字符串 s 和 t
 * t 由 s 中的字符随机重排，并在随机位置插入一个字符，找出插入的字符
 */
public class No389FindTheDifference {

    public static void main(String[] args) {
        
    }
    
    /**
     * 原理说明：对数字自身进行异或操作，结果为0: a^a=0, 写成xor(2a)=0则：
     * s和t的字符全部加起来可组合为 2a+2b+2c+...+x; 因此对两个字符串的所有字符进行异或运算后即为x
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        char res = 0, i = 0;
        for(; i < s.length(); i++) {
            res ^= s.charAt(i);
        }
        for(i = 0; i < t.length(); i++) {
            res ^= t.charAt(i);
        }
        return res;
    }
}

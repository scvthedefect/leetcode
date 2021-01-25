package cn.lawrence.leetcode.solution.easy;

/**
 * 字符串中的单词数
 */
public class No434NumberOfSegmentsInString {
    
    static No434NumberOfSegmentsInString sample = new No434NumberOfSegmentsInString();

    public static void main(String[] args) {
        test("");
        test("    ");
        test("  ,  ");
        test("Hello, my name is John");
        test(" Hello, my name is John ");
    }
    
    public static void test(String s) {
        int count = sample.countSegments(s);
        System.out.println(String.format("\"%s\": %d", s, count));
    }
    
    public int countSegments(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        int i = 0, j = s.length() - 1, tmp = 0, count = 0;
        // 忽略头尾的空格
        while(i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        while(j >= 0 && s.charAt(j) == ' ') {
            j--;
        }
        while(i <= j) {
            while(i < s.length() && s.charAt(i) != ' ') {
                i++;
            }
            count++;
            tmp = i;
            while(tmp < s.length() && s.charAt(tmp) == ' ') { // 单词中间可能有多个空格
                tmp++;
            }
            i = tmp;
        }
        return count;
    }
    
}

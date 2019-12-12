package cn.lawrence.leetcode.solution.easy;

/**
 * 猜数字游戏
 * 
 */
public class No299BullsAndCows {
    
    public static void main(String[] args) {
        test("1807", "7810", "1A3B");
        test("1123", "0111", "1A1B");
        
        test("1123", "11111", "2A0B");
    }
    
    static No299BullsAndCows sample = new No299BullsAndCows();
    public static void test(String secret, String guess, String expected) {
        String res = sample.getHint(secret, guess);
        System.out.println(String.format("secret: %s, guess: %s, res: %s, as expected: %b", 
                secret, guess, res, (expected.equals(res))));
    }
    
    public String getHint(String secret, String guess) {
        String tmp = "%dA%dB";
        int bulls = 0;
        int cows = 0;
        int len = secret.length() < guess.length() ? secret.length() : guess.length();
        int i = 0;
        char cs, cg;
        int[] countS = new int[10];
        int[] countG = new int[10];
        int index;
        for(; i < len; i++) {
            cs = secret.charAt(i);
            cg = guess.charAt(i);
            if(cs == cg) {
                bulls++;
            } else {
                index = cs - '0';
                countS[index]++;
                
                index = cg - '0';
                countG[index]++;
            }
        }
        
        // secret和guess中最多只有一个未完成遍历，因此两个循环最多只有一个会被执行
        for(; i < secret.length(); i++) {
            index = secret.charAt(i) - '0';
            countS[index]++;
        }
        for(; i < guess.length(); i++) {
            index = guess.charAt(i) - '0';
            countG[index]++;
        }
        
        for(i = 0; i < 10; i++) {
            if(countS[i] > 0 && countG[i] > 0) {
                cows += Math.min(countS[i], countG[i]);
            }
        }
        return String.format(tmp, bulls, cows);
    }
}

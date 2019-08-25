package cn.lawrence.leetcode.solution.easy;

/**
 * 最长回文串：返回由字符串s包含的字符组成的最长回文字符串长度
 * 如s="abccccdd", result=7, 即 "dccaccd"
 */
public class No409LongestPalindrome {
    
    static No409LongestPalindrome sample = new No409LongestPalindrome();
    
    public static void main(String[] args) {
        test("abccccdd");
        test("");
        test("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth");
    }
    
    public static void test(String s) {
        int result = sample.longestPalindrome(s);
        System.out.println(result);
    }

    /**
     * 计数排序的变种：该问题的解为所有偶数与最大奇数之和
     * @param s 最大长度为1010
     * @return
     */
    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        char[] arr = s.toCharArray();
        int min = arr[0], max = arr[0], i = 1;
        for(; i < arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        int[] c = new int[max - min + 1];
        for(i = 0; i < arr.length; i++) {
            c[arr[i] - min]++;
        }
        int count = 0;
        boolean hasOdd = false;
        for(i = 0; i < c.length; i++) {
            if(c[i] == 0) {
                continue;
            }
            
            if(c[i] % 2 == 0) { // 偶数
                count += c[i];
            } else { // 奇数
                count += c[i] - 1;
                hasOdd = true;
            }
        }
        return hasOdd ? count + 1 : count;
    }
    
}

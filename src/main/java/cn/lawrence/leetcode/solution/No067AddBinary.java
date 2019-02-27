package cn.lawrence.leetcode.solution;

public class No067AddBinary {
    
    public static void main(String[] args) {
        test("1", "1", "10");
        test("111", "11", "1010");
        test("0000", "000", "0000");
    }
    
    public static void test(String a, String b, String expect) {
        Solution67 solution = new Solution67();
        String output = solution.addBinary(a, b);
        
        boolean isExpected = expect.equals(output);
        System.out.println(String.format("output: %s; match: %b", output, isExpected));
    }

}

class Solution67 {
    
    public String addBinary(String a, String b) {
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        
        StringBuilder sb = new StringBuilder();
        boolean isPlus = false; // 是否进一
        boolean goNext = true;
        while(goNext) {
            char ca = aIndex >= 0 ? a.charAt(aIndex) : '0';
            char cb = bIndex >= 0 ? b.charAt(bIndex) : '0';
            
            int val = 0;
            if(ca != '0') {
                val++;
            }
            if(cb != '0') {
                val++;
            }
            if(isPlus) {
                val++;
            }
            
            if(val > 1) {
                isPlus = true;
                val = val %2;
            }else{
                isPlus = false;
            }
            
            sb.insert(0, val);
            goNext = aIndex > 0 || bIndex > 0 || isPlus;
            if(goNext) {
                aIndex--;
                bIndex--;
            }
        }
        return sb.toString();
    }
    
}

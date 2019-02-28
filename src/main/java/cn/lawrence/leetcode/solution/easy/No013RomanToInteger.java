package cn.lawrence.leetcode.solution.easy;

public class No013RomanToInteger {

    public static void main(String[] args) {
        // 正常情况
        test("III", 3);
        test("IV", 4);
        test("IX", 9);
        test("LVIII", 58);
        test("MCMXCIV", 1994);
        
        // 异常情况
        test("AABB", 0); // 非法字符
        test("", 0);
    }
    
    /**
     * 注意特殊情况的处理：
     * 1. 输入非法字符
     * 2. 整数溢出不处理，因为导致溢出所需的字符串过长
     * @param str
     * @param expect
     */
    public static void test(String str, int expect) {
        Solution013 s = new Solution013();
//        int value = s.romanToInt(str);
        int value = s.romanToIntModified(str);
        System.out.println(String.format("intput: %s, convert: %d, expected: %b", str, value, (value == expect)));
    }
    
}

class Solution013 {
    
    public int romanToInt(String s) {
        int result = 0;
//        if(s == null || s.trim().length() == 0) {
//            return result;
//        }
        if(s == null || s == "") { // String.trim() 对性能消耗较大
            return result;
        }
        
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            char c = arr[i];
            c = Character.toUpperCase(c);
            Roman current = Roman.getInstance(c);
            
            boolean isCombine = false;
            int digitValue = 0;
            
            int nextIndex = i + 1;
            if(nextIndex != arr.length) {
                char n = Character.toUpperCase(arr[nextIndex]);
                Roman next = Roman.getInstance(n);
                int diff = next.getValue() - current.getValue();
                isCombine = diff > 0;
                
                if(isCombine) {
                    digitValue = diff;
                    i++;
                }
            }
            
            if(!isCombine) {
                digitValue = current.getValue();
            }
            
            result += digitValue;
        }
        
        return result;
    }
    
    public int romanToIntModified(String s) {
        int result = 0;
        if(s == null || s == "") {
            return result;
        }
        
        char c1 = 0;
        char c2 = 0;
        int v1 = 0;
        int v2 = 0;
        
        int v = 0;
        int diff = 0;
        
        char[] arr = s.toCharArray();
        int len = arr.length;
        for(int i = 0; i < len; i++) {
//            c1 = s.charAt(i);
            c1 = arr[i];
            v1 = this.getRomanValue(c1);

            if(i != len - 1) {
//                c2 = s.charAt(i + 1);
                c2 = arr[i + 1];
                v2 = this.getRomanValue(c2);                
            } else {
                v2 = 0;
            }
            
            diff = v2 - v1;
            if(diff > 0) {
                v = diff;
                i++;
            } else {
                v = v1;
            }
            
            result += v;
        }
        return result;
    }
    
    public int getRomanValue(char c) {
        int value = 0;
        switch (c) {
        case 'I':
            value = 1;
            break;
        case 'V':
            value = 5;
            break;
        case 'X':
            value = 10;
            break;
        case 'L':
            value = 50;
            break;
        case 'C':
            value = 100;
            break;
        case 'D':
            value = 500;
            break;
        case 'M':
            value = 1000;
            break;
        default:
            break;
        }
        return value;
    }
    
}

enum Roman {
    
    I('I', 1),
    V('V', 5),
    X('X', 10),
    L('L', 50),
    C('C', 100),
    D('D', 500),
    M('M', 1000),
    DEFAULT(' ', 0),
    
    ;
    
    private Roman(char digit, int value) {
        this.digit = digit;
        this.value = value;
    }
    
    public static Roman getInstance(char c) {
        for(Roman roman : Roman.values()) {
            if(roman.digit == c) {
                return roman;
            }
        }
        return DEFAULT;
    }
    
    private char digit;
    
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
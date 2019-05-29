package cn.lawrence.leetcode.solution.easy;

public class No190ReverseBits {
    
    public static void main(String[] args) {
//        test(8);
//        test(-8);
//        test(-11);
        
        int n = 43261596; // 00000010100101000001111010011100
        test(n);
        
        n = -43261596;
        test(n);
        
//        int n = 0b00000010100101000001111010011100;
//        System.out.println(n);
//        
//        n = 0b00111001011110000010100101000000;
//        System.out.println(n);
    }
    
    public static void test(int n) {
        Solution190 s = new Solution190();
//        n = s.reverseBits(n);
//        n = s.reverseBitsModified(n);
        
//        n = s.reverseBitsV2(n);
//        n = s.reverseBitsV2Modified(n);
        n = s.reverseBitsV3(n);
        
        System.out.println(String.format("output: %d", n));
        System.out.println("=====================");
    }

}

class Solution190 {
    
    public int reverseBitsV3(int n) {
        int out = 0;
        for(byte i = 0; i < Integer.SIZE; i++) {
            out <<= 1;
            out += (n & 0x1);
            n >>= 1;
        }
        return out;
    }
    
    public int reverseBitsV2Modified(int n) {
        int out = 0;
        byte temp = 0;
        for(byte i = 0; i < Integer.SIZE; i++) {
            temp = (byte) (n & 0x1);
            n >>= 1;

            out <<= 1;
            out += temp;
        }
        return out;
    }
    
    public int reverseBitsV2(int n) {
        int temp = 0, out = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < 32; i++) {
            temp = n & 1;
            n = n >> 1;
        sb.append(temp);
        
        out = out << 1;
        out += temp;
        }
        
        String str = sb.toString();
        System.out.println(String.format("sb: %s", str));
        
        int t = Integer.parseUnsignedInt(str, 2);
        System.out.println(String.format("十进制表示: %d", t));
        
        System.out.println(String.format("out: %d", out));
        
        return out;
    }
    
    public int reverseBitsModified(int n) {
        System.out.println(String.format("input: %d", n));
        String str = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder(32);
        int len = str.length();
        if(len != 32) { // 不满32位（正数），在前面补零
            for(int i = 0; i < 32 - len; i++) {
                sb.append(0);
            }
        }
        
        str = sb.append(str).reverse().toString();
        System.out.println(String.format("倒置后: %s", str));
        n = Integer.parseUnsignedInt(str, 2);
        return n;
        
//        String str = Integer.toBinaryString(n);
//        str = new StringBuilder(str).reverse().toString();
//        int len = str.length();
//        if(len != 32) {
//            StringBuilder sb = new StringBuilder(32);
//            char c = '0';
//            for(int i = 0; i < 32; i++) {
//                c = i < len ? str.charAt(i) : '0';
//                sb.append(c);
//            }
//            str = sb.toString();
//        }
//        n = Integer.parseUnsignedInt(str, 2);
//        return n;
    }
    
    public int reverseBits(int n) {
//        String str = Integer.toBinaryString(n);
//        System.out.println(String.format("1. toBinaryString: %s", str));
        
//        str = Integer.toString(n, 2);
//        System.out.println(String.format("2. toString: %s", str));
        
//        String temp = Integer.toUnsignedString(n, 2);
//        System.out.println(String.format("toUnsignedString: %s", temp));
        System.out.println(String.format("0. input: %d", n));
        
        String str = Integer.toBinaryString(n);
        System.out.println(String.format("1. toBinaryString: %s", str));
        
        str = new StringBuilder(str).reverse().toString();
        System.out.println(String.format("3. reverse: %s", str));
        
        int len = str.length();
        if(len != 32) {
            StringBuilder sb = new StringBuilder(32);
            char c = '0';
            for(int i = 0; i < 32; i++) {
                c = i < len ? str.charAt(i) : '0';
                sb.append(c);
            }
            str = sb.toString();
        }
        System.out.println(String.format("4. format: %s", str));
        n = Integer.parseUnsignedInt(str, 2);
        return n;
    }
    
//    public int reverseBits(int n) {
//        String str = Integer.toString(n, 2);
//        System.out.println(String.format("input: %s", str));
//        boolean isNegative = str.charAt(0) == '-';
//        char c = isNegative ? '1' : '0'; // 先处理符号位
//        if(isNegative) {
//            str = str.substring(1);
//        }
//        
//        int len = 32;
//        StringBuilder sb = new StringBuilder(len);
//        sb.append(c);
//        
//        // 补充成二进制形式
//        int index = len - str.length() - 1;
//        for(int i = 1; i < len; i++) {
//            int x = i - index - 1;
//            c = i > index ? str.charAt(x) : '0';
//            sb.append(c);
//        }
//        System.out.println(String.format("补充：%s", sb.toString()));
//        sb.reverse();
//        System.out.println(String.format("倒转: %s", sb.toString()));
//        
//        if(sb.charAt(0) == '1') {
//            sb.insert(0, '-');
//        }
//        str = sb.toString();
//        System.out.println(String.format("转换：%s", str));
//        return Integer.valueOf(str, 2);
//    }
    
//    public int reverseBits(int n) {
//        String str = Integer.toString(n, 2);
//        System.out.println(String.format("input: %s", str));
//        int len = str.length();
//        StringBuilder sb = new StringBuilder(len);
//        
//        char c = 0;
//        for(int i = 0; i < 32; i++) {
//            c = i > len - 1 ? '0' : str.charAt(len - i - 1);
//            c =  c == '-' ? '0' : c;
//            sb.append(c);
//        }
//        str = sb.toString();
//        
//        System.out.println(String.format("output: %s", str));
//        System.out.println("==============");
//        return Integer.valueOf(str, 2);
//    }
    
}

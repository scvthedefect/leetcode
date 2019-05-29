package cn.lawrence.leetcode.solution.easy;

import java.util.HashMap;

public class No202HappyNumber {
    
    public static void main(String[] args) {
//        test(19);
//        test(0);
        test(Integer.MAX_VALUE);
    }
    
    public static void test(int n) {
        Solution202 s = new Solution202();
        boolean flag = s.isHappy(n);
        System.out.println(String.format("isHappy: %b", flag));
    }

}

class Solution202 {
    
    public boolean isHappy(int n) {
        boolean isHappy = false;
        if(n <= 0) {
            return isHappy;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int mod, sum, temp = n;
        while(true) {
            mod = 0;
            sum = 0;
            while(temp > 0) {
                mod = temp % 10;
                sum += mod * mod;
                temp /= 10;
            }
            
            if(sum == 1) {
                return true;
            }
            
            if(map.containsKey(sum)) {
                return false;
            }
            
            map.put(sum, sum);
            temp = sum;
        }
    }
    
}

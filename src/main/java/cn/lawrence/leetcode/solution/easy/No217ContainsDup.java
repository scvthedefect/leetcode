package cn.lawrence.leetcode.solution.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No217ContainsDup {
    
    public static void main(String[] args) {
        test(true, 1,2,3,1);
        test(false, 1,2,3,4);
        test(true, 1,1,1,3,3,4,3,2,4,2);
        test(false);
    }
    
    public static void test(boolean expect, int...nums) {
        Solution217 s = new Solution217();
        boolean flag = s.containsDuplicate(nums);
        System.out.println(String.format("input: %s, as expect: %b", Arrays.toString(nums), (flag == expect)));
    }

}


class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer n : nums) {
            if(map.containsKey(n)) {
                return true;
            }
            
            map.put(n, n);
        }
        return false;
    }
}
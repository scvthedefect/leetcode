package cn.lawrence.leetcode.solution.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No219ContainsDup {
    
    public static void main(String[] args) {
        test(true, 3, 1,2,3,1);
        test(true, 1, 1,0,1,1);
        test(false, 2, 1,2,3,1,2,3);
        test(false, 1);
    }

    public static void test(boolean expected, int k, int...nums) {
        Solution219 s = new Solution219();
        boolean flag = s.containsNearbyDuplicate(nums, k);
        System.out.println(String.format("input: %s, k=%d, as expected=%b", 
                Arrays.toString(nums), k, (flag == expected)));
    }
    
}

class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>(); 
        for(int i = 0; i < nums.length; i++) {
            Integer n = nums[i];
            if(map.containsKey(n)) {
                List<Integer> list = map.get(n);
                for(int pos : list) {
                    if(Math.abs(pos - i) <= k) {
                        return true;
                    }
                }
                list.add(i);
            }
            
            List<Integer> list = new ArrayList<>();
            list.add(i);
            map.put(n, list);
        }
        return false;
    }
}

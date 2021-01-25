package cn.lawrence.leetcode.solution.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No229MajorityElement2 {
    
    public static void main(String[] args) {
        test(3,2,3);
        test(1,1,1,3,3,2,2,2);
    }

    public static void test(int...nums) {
        Solution229 s = new Solution229();
        List<Integer> list = s.majorityElement(nums);
        System.out.println(list.toString());
    }
    
}

class Solution229 {
    
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            Integer key = Integer.valueOf(nums[i]);
            if(map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        
        int oneThird = nums.length / 3;
        List<Integer> list = new ArrayList<>();
        for(Integer key : map.keySet()) {
            Integer value = map.get(key);
            if(value > oneThird) {
                list.add(key);
            }
        }
        return list;
    }
    
}

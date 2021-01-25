package cn.lawrence.leetcode.solution.easy;

import java.util.HashMap;
import java.util.Map;

public class No169MajorityElement {
    
    public static void main(String[] args) {
        test(3, 3,2,3);
        test(2, 2,2,1,1,1,2,2);
        
        test(3, 3,3,4);
    }
    
    public static void test(int expected, int...nums) {
        Solution169 s = new Solution169();
        int result = s.majorityElement(nums);
        assert expected == result: String.format("expected: %d, result: %d", expected, result);
    }

}

class Solution169 {
    
    /**
     * 返回数组中的众数（出现次数大于n/2）
     * @param nums 假定给出的数组非空且有众数
     * @return
     */
    public int majorityElement(int[] nums) {
        int half = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            Integer key = Integer.valueOf(nums[i]);
            if(map.containsKey(key)) {
                int count = map.get(key) + 1;
                map.put(key, count);
                
            } else {
                map.put(key, 1);
            }
        }
        int index = -1, count = 0;
        for(Integer key : map.keySet()) {
            if(map.get(key) > count) {
                index = key;
                count = map.get(key);
            }
        }
        return index;
    }
    
}
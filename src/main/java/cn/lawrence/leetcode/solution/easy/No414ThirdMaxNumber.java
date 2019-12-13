package cn.lawrence.leetcode.solution.easy;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 第三大的数
 */
public class No414ThirdMaxNumber {

    static No414ThirdMaxNumber sample = new No414ThirdMaxNumber();
    
    public static void main(String[] args) {
        test(1, 3,2,1);
        test(2, 1,2);
        test(1, 2,2,3,1);
        test(2, 1,1,2); // 重复的不计算在内
        test(2, 2,2,2);
        test(1, 1,2,3);
        
        test(-5, -10,-5,0,10);
        
    }
    
    public static void test(int expect, int...nums) {
        int res = sample.thirdMax(nums);
        System.out.println(String.format("result: %d, as expected: %b", res, (res == expect)));
    }
    
    public int thirdMax(int[] nums) {
        // 用例限制无法使用计数排序方式
        
        Map<Integer, Integer> map = new TreeMap<>(); // 数组含负数
        for(int i = 0; i < nums.length; i++) {
            map.put(Integer.valueOf(nums[i]), 1);
        }
        
        Iterator<Integer> iter = map.keySet().iterator();
        int len = map.keySet().size();
        int lastIndex = len >= 3 ? len - 3 : len - 1;
        Integer n = null;
        for(int i = 0; i <= lastIndex; i++) {
            n = iter.next();
        }
        return n.intValue();
    }
    
}

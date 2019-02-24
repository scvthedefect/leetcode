package cn.lawrence.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和：简单
 * https://leetcode-cn.com/problems/two-sum/
 * 
 * 简单实现：时间复杂度为 O(n^2)
 * 优化实现：时间复杂度为 O(n)
 */
public class No001TwoSum {

    public static void main(String[] args) {
        int[] arr = {2, 7, 10, 11};
        int target = 9;
        test(arr, target);
        testOptimized(arr, target);
    }
    
    public static void test(int[] nums, int target) {
        long start = System.currentTimeMillis();
        
        int[] result = twoSum(nums, target);
        if(result.length > 0) {
            System.out.println(String.format("[%d, %d]", result[0], result[1]));
        }
        
        long end = System.currentTimeMillis();
        long duration = end - start;
        System.out.println(String.format("duration: %d ms.", duration));
    }
    
    public static void testOptimized(int nums[], int target) {
        long start = System.currentTimeMillis();
        int[] result = twoSumOptimized(nums, target);
        if(result.length > 0) {
            System.out.println(String.format("[%d, %d]", result[0], result[1]));
        }
        
        long end = System.currentTimeMillis();
        long duration = end - start;
        System.out.println(String.format("duration: %d ms.", duration));
    }

    /**
     * 两数相加，时间复杂度为 O(n^2), 空间复杂度为 O(1)
     * 
     * @param nums
     * @param target
     * @return nums数组中相加为target值的元素组成的索引（数组），不存在则返回长度为2的数组
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * 两数相加优化版，时间复杂度为 O(n), 空间负责度为 O(n)
     * 
     * @param nums
     * @param target
     * @return nums数组中相加为target值的元素组成的索引（数组），不存在则返回长度为2的数组
     */
    public static int[] twoSumOptimized(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer index = map.get(target - num);
            if(index != null) {
                result[0] = index;
                result[1] = i;
                return result;
            }
            map.put(num, i);
        }
        return result;
    }
    
}

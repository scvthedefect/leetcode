package cn.lawrence.leetcode.solution.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 相对名次
 */
public class No506RelativeRanks {
    
    public static void main(String[] args) {
        test(1,4,2,3,6,5);
    }
    
    public static void test(int...nums) {
        No506RelativeRanks s = new No506RelativeRanks();
        String[] strs = s.findRelativeRanks(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(strs));
    }
    
    public String[] findRelativeRanks(int[] nums) {
        int[] ranks = this.countSort(nums);
        int len = nums.length;
        int i = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(i = 0; i < len; i++) {
            map.put(ranks[i], i); // 记录分数对应的位置
        }
        String[] strs = new String[len];
        int index = 0;
        String str = null;
        for(i = 0; i < len; i++) {
            index = map.get(nums[i]);
            switch (index) {
            case 0:
                str = "Gold Medal";
                break;
            case 1:
                str = "Silver Medal";
                break;
            case 2:
                str = "Bronze Medal";
                break;
            default:
                str = Integer.toString(index + 1);
                break;
            }
            strs[i] = str;
        }
        return strs;
    }
    
    public int[] countSort(int[] nums) {
        int max = 0, min = 0;
        for(int n : nums) {
            if(n > max) {
                max = n;
            }
            if(n < min) {
                min = n;
            }
        }
        int[] c = new int[max - min + 1];
        int i = 0;
        for(i = 0; i < nums.length; i++) {
            c[nums[i] - min]++;
        }
        for(i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }
        int[] b = new int[nums.length];
        for(i = 0; i < nums.length; i++) {
            b[--c[nums[i] - min]] = nums[i];
        }
        
        // 倒序
        for(i = 0; i < nums.length / 2; i++) {
            b[i] ^= b[nums.length - i - 1];
            b[nums.length - i - 1] ^= b[i];
            b[i] ^= b[nums.length - i - 1];
        }
        return b;
    }

}

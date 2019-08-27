package cn.lawrence.leetcode.solution.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 找到数组中消失的所有整数
 */
public class No448FindAllNumbers {
    
    static No448FindAllNumbers sample = new No448FindAllNumbers();
    
    public static void main(String[] args) {
//        test(1,2,3,4,5,5,7);
//        test(1,2,3,3,5,5,7);
        test(4,3,2,7,8,2,3,1);
    }
    
    public static void test(int...nums) {
//        List<Integer> res = sample.findDisappearedNumbers(nums);
        List<Integer> res = sample.findDisappearedNumbers_V2(nums);
        System.out.println(res.toString());
    }
    
    public List<Integer> findDisappearedNumbers_V2(int[] nums) {
        if(nums.length == 0) {
            return Collections.emptyList();
        }
        
        for(int i = 0; i < nums.length; i++) {
            int index = nums[i];
            index = (index > 0 ? index : -index) - 1;
            if(nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }
    
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums.length == 0) {
            return Collections.emptyList();
        }
        
        List<Integer> list = new ArrayList<>();
        int[] tmp = new int[nums.length];
        int i = 0;
        for(; i < nums.length; i++) {
            tmp[nums[i] - 1]++;
        }
        for(i = 0; i < nums.length; i++) {
            if(tmp[i] == 0) {
                list.add(i + 1);
            }
        }
        return list;
    }

}

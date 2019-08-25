package cn.lawrence.leetcode.solution.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 两个数组的交集
 */
public class No350IntersectionsOfTwoArrays {
    
    static No350IntersectionsOfTwoArrays sample = new No350IntersectionsOfTwoArrays();
    
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        
//        int[] nums1 = {4,9,5};
//        int[] nums2 = {9,4,9,8,4};
        
//        int[] nums1 = {};
//        int[] nums2 = {9,4,9,8,4};
        
//        int[] nums1 = {-2147483648,1,2,3};
//        int[] nums2 = {1,-2147483648,-2147483648};
        
//        int[] res = sample.intersect(nums1, nums2);
        int[] res = sample.intersect_V2(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }
    
    public int[] intersect_V2(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer n : nums1) {
            Integer count = map.get(n);
            if(count == null) {
                map.put(n, 1);
            } else {
                map.put(n, count + 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(Integer n : nums2) {
            Integer count = map.get(n);
            if(count != null && count > 0) {
                list.add(n);
                map.put(n, count - 1);
            }
        }
        int[] res = new int[list.size()];
        int i = 0;
        for(Integer n : list) {
            res[i++] = n;
        }
        return res;
    }
    
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        
        int[] shrt = nums1.length <= nums2.length ? nums1 : nums2;
        int[] lng = shrt == nums1 ? nums2 : nums1;
        
        int min = shrt[0], max = shrt[0], i = 1;
        for(; i < shrt.length; i++) {
            if(shrt[i] < min) {
                min = shrt[i];
            }
            if(shrt[i] > max) {
                max = shrt[i];
            }
        }
        int[] c = new int[max - min + 1];
        for(i = 0; i < shrt.length; i++) {
            c[shrt[i] - min]++;
        }
        List<Integer> list = new ArrayList<>();
        for(i = 0; i < lng.length; i++) {
            int index = lng[i] - min;
            if(index < 0 || index >= c.length) {
                continue;
            }
            if(c[index] == 0) {
                continue;
            }
            list.add(lng[i]);
            c[index]--;
        }
        
        int[] res = new int[list.size()];
        i = 0;
        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext()) {
            res[i++] = iter.next();
        }
        return res;
    }

}

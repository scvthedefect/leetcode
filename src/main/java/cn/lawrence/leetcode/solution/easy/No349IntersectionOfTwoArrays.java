package cn.lawrence.leetcode.solution.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 两个数组的交集
 */
public class No349IntersectionOfTwoArrays {
    
    static No349IntersectionOfTwoArrays sample = new No349IntersectionOfTwoArrays();
    
    public static void main(String[] args) {
        case1();
        case2();
        case3();
    }
    
    public static void case1() {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        
//        int[] res = sample.intersections_V1(nums1, nums2);
        int[] res = sample.intersections_V2(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }
    
    public static void case2() {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        
//        int[] res = sample.intersections_V1(nums1, nums2);
        int[] res = sample.intersections_V2(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }
    
    public static void case3() {
        int[] nums1 = {};
        int[] nums2 = {9,4,9,8,4};
        
//        int[] res = sample.intersections_V1(nums1, nums2);
        int[] res = sample.intersections_V2(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }
    
    public int[] intersections_V1(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0) {
            return nums1.length == 0 ? nums1 : nums2;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums1) {
            map.put(n, 0);
        }
        Map<Integer, Integer> map2 = new HashMap<>();
        for(int n : nums2) {
            if(map.get(n) != null) {
                map2.put(n, 0);
            }
        }
        
        Set<Integer> set = map2.keySet();
        Iterator<Integer> iter = map2.keySet().iterator();
        int[] res = new int[set.size()];
        for(int i = 0; i < set.size(); i++) {
            res[i] = iter.next();
        }
        return res;
    }
    
    public int[] intersections_V2(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0) {
            return nums1.length == 0 ? nums1 : nums2;
        }
        
        int[] lng = nums1.length >= nums2.length ? nums1 : nums2; // 以较长数组作为操作对象
        int[] shrt = lng == nums1 ? nums2 : nums1;
        int min = lng[0], max = lng[0];
        int i = 1;
        for(; i < lng.length; i++) {
            if(lng[i] < min) {
                min = lng[i];
            }
            if(lng[i] > max) {
                max = lng[i];
            }
        }
        int[] c = new int[max - min + 1];
        for(i = 0; i < lng.length; i++) {
            c[lng[i] - min]++;
        }
        Set<Integer> set = new HashSet<>();
        for(i = 0; i < shrt.length; i++) {
            int index = shrt[i] - min;
            if(index >= 0 && index < c.length && c[index] > 0) {
                set.add(shrt[i]);
            }
        }
        int[] res = new int[set.size()];
        Iterator<Integer> iter = set.iterator();
        for(i = 0; i < set.size(); i++) {
            res[i] = iter.next();
        }
        return res;
    }

}

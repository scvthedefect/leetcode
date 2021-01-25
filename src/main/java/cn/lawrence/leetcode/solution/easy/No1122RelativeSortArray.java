package cn.lawrence.leetcode.solution.easy;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class No1122RelativeSortArray {
    
    static No1122RelativeSortArray sample = new No1122RelativeSortArray();
    
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        test(arr1, arr2);
    }
    
    public static void test(int[] arr1, int[] arr2) {
//        int[] result = sample.relativeSortArray(arr1, arr2);
        int[] result = sample.relativeSortArrayV2(arr1, arr2);
        System.out.println(Arrays.toString(result));
    }
    
    public int[] relativeSortArrayV2(int[] arr1, int[] arr2) {
        // 确定统计的范围，减少内存占用
        int min = arr1[0], max = arr1[0];
        int i = 1;
        for(; i < arr1.length; i++) {
            if(arr1[i] < min) {
                min = arr1[i];
            }
            if(arr1[i] > max) {
                max = arr1[i];
            }
        }
        int[] tmp = new int[max - min + 1];
        for(i = 0; i < arr1.length; i++) {
            tmp[arr1[i] - min]++; // 统计arr1中各元素的数量
        }
        int[] res = new int[arr1.length];
        int index = 0, count = 0;
        for(i = 0; i < arr2.length; i++) { // 首次遍历处理出现在arr2的元素
            count = tmp[arr2[i] - min];
            while(count-- > 0) {
                res[index++] = arr2[i];
            }
            tmp[arr2[i] - min] = 0;
        }
        for(i = 0; i < tmp.length; i++) { // 第二次遍历处理arr2中没有的元素
            count = tmp[i];
            while(count-- > 0) {
                res[index++] = i + min;
            }
        }
        return res;
    }
    
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new TreeMap<>();
        for(Integer n : arr1) {
            if(map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        
        int[] arr = new int[arr1.length];
        int index = 0, count = 0;
        for(Integer n : arr2) {
            count = map.get(n);
            while(count-- > 0) {
                arr[index++] = n;
            }
            map.remove(n);
        }
        
        for(Integer n : map.keySet()) {
            count = map.get(n);
            while(count-- > 0) {
                arr[index++] = n;
            }
        }
        return arr;
    }

}

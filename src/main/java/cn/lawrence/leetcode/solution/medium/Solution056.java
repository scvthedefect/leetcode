package cn.lawrence.leetcode.solution.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * 合并区间
 * @author Lawrence
 */
public class Solution056 {
    
    public static void main(String[] args) {
        Solution056 solution = new Solution056();
//        int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}}; // [[1,6],[8,10],[15,18]]
//        int[][] intervals = {{1,4}, {4,5}}; // [[1,5]]
//        int[][] intervals = {{1,5}, {2,3}, {4,4}}; // [[1, 5]]
        int[][] intervals = {{1,5}, {6,7}}; // [[1,5], [6,7]]
        
        int[][] result = solution.merge(intervals);
        
        for (int[] tmp : result) {
            System.out.println(Arrays.toString(tmp));
        }
    }
    
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int a = o1[0];
                int b = o2[0];
                if (a < b) {
                    return -1;
                } else if (a == b) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        Stack<int[]> stack = new Stack<>();
        int b, c, d;
        int[] prev;
        for (int[] element : intervals) {
            if (stack.isEmpty()) {
                stack.push(element);
                continue;
            }
            prev = stack.peek();
            b = prev[1];
            
            c = element[0]; // current
            d = element[1];
            if (c > b) {
                stack.add(element);
            } else {
                b = b > d ? b : d;
                prev[1] = b;
            }
            
        }
        int size = stack.size();
        int[][] result = new int[size][];
        int i = size - 1;
        while (!stack.isEmpty()) {
            result[i--] = stack.pop();
        }
        return result;
    }
    
    public int[][] mergeWrong(int[][] intervals) {
        int length = intervals.length;
        int min = intervals[0][0];
        int max = min;
        int[] tmp;
        int a, b;
        for (int i = 0; i < length; i++) {
            tmp = intervals[i];
            a = tmp[0];
            b = tmp[1];
            
            if (a < min) {
                min = a;
            }
            if (b > max) {
                max = b;
            }
        }
        
        int[] bucket = new int[max - min + 1];
        for (int i = 0; i < length; i++) {
            tmp = intervals[i];
            a = tmp[0];
            b = tmp[1];
            while (a <= b) {
                bucket[a - min]++;
                a++;
            }
        }
        
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] == 0) {
                continue;
            }
            int j = i;
            while (j < bucket.length && bucket[j] > 0) {
                j++;
            }
            int end = j - 1;
            tmp = new int[2];
            tmp[0] = i + min;
            tmp[1] = end + min;
            i = end;
            list.add(tmp);
        }
        int[][] result = (int[][]) list.toArray(new int[0][0]);
        return result;
    }

}

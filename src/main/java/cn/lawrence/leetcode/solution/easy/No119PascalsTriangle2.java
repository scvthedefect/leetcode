package cn.lawrence.leetcode.solution.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 杨辉三角2:要求空间复杂度为O(k)
 */
public class No119PascalsTriangle2 {
    
    public static void main(String[] args) {
        No119PascalsTriangle2 s = new No119PascalsTriangle2();
        List<Integer> list = s.getRow(5);
        System.out.println(list.toString());
    }
    
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex < 0) {
            return Collections.emptyList();
        }
        
        int[] arr = new int[rowIndex + 1];
        int i = 0, j = 0, num = 0;
        for(i = 0; i <= rowIndex; i++) {
            for(j = i; j >= 0; j--) {
                if(j == 0 || j == i) {
                    num = 1;
                } else {
                    num = arr[j - 1] + arr[j];
                }
                arr[j] = num;
            }
        }
        List<Integer> list = new ArrayList<>(rowIndex + 1);
        for(i = 0; i <= rowIndex; i++) {
            list.add(arr[i]);
        }
        return list;
    }

}

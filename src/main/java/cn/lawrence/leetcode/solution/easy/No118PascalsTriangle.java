package cn.lawrence.leetcode.solution.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 杨辉三角
 */
public class No118PascalsTriangle {
    
    public static void main(String[] args) {
        No118PascalsTriangle s = new No118PascalsTriangle();
        List<List<Integer>> list = s.generate(5);
        System.out.println(list.toString());
    }
    
    public List<List<Integer>> generate(int numRows) {
        if(numRows <= 0) {
            return Collections.emptyList();
        }
        
        List<List<Integer>> list = new ArrayList<>();
        int i = 1, j = 1, num = 0;
        List<Integer> prev = null;
        for(i = 1; i <= numRows; i++) {
            List<Integer> tmp = new ArrayList<>(i);
            for(j = 1; j <= i; j++) {
                if(j == 1 || j == i) {
                    num = 1;
                } else {
                    num = prev.get(j - 2) + prev.get(j - 1);
                }
                tmp.add(num);
            }
            list.add(tmp);
            prev = tmp;
        }
        return list;
    }

}

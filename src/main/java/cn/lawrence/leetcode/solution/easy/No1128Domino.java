package cn.lawrence.leetcode.solution.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 等价多米诺骨牌对数
 */
public class No1128Domino {
    
    static No1128Domino sample = new No1128Domino();
    public static void main(String[] args) {
        int[][] case1 = {{1, 2}, {2, 1}, {3, 4}, {5, 6}}; // expected = 1
        test(case1, 1);
        
        int[][] case2 = {};
        test(case2, 0);
        
        int[][] case3 = {{2, 1}, {1, 2}, {2, 1}};
        test(case3, 3);
        
        int[][] case4 = {{2, 1}, {1, 2}, {2, 1}, {2, 2}, {2, 2}, {2, 3}};
        test(case4, 4);
        
        int[][] case5 = {{3, 1}, {1, 3}, {1, 3}, {1, 1}, {2, 2}};
        test(case5, 3);
    }
    
    public static void test(int[][] dominoes, int expected) {
        int res = sample.numEquivDominoPairs(dominoes);
        System.out.println(String.format("expected=%d, result=%d", expected, res));
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> map = new HashMap<>(); // 用于统计牌的数量
        for(int[] d: dominoes) {
            if(d[0] > d[1]) {
                d[0] ^= d[1];
                d[1] ^= d[0];
                d[0] ^= d[1];
            }
            String key = d[0] + "-" + d[1];
            if(map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        int sum = 0;
        for(String key : map.keySet()) {
            int count = map.get(key) != null ? map.get(key) : 0;
            if(count <= 1) {
                continue;
            }
            
            int tmp = 0, n = 1;
            while(n <= count) {
                tmp = tmp + n - 1;
                n++;
            }
            sum += tmp;
        }
        return sum;
    }
}

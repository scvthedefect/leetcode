package cn.lawrence.leetcode.solution.easy;

import java.util.Arrays;

/**
 * 学生按照 非递减 的高度顺序排列。
 * 找出能让所有学生以 非递减 高度排列的必要移动人数。
 * 
 * 示例：
 * 输入：[1,1,4,2,1,3]
 * 输出：3
 * 解释：高度为 4、3 和最后一个 1 的学生，没有站在正确的位置。
 */
public class No1051HeightChecker {
    
    static No1051HeightChecker sample = new No1051HeightChecker();
    
    public static void main(String[] args) {
        // 第一个数为预期值
        test(3, 1,1,4,2,1,3);
    }
    
    public static void test(int expect, int...heights) {
        int res = sample.heightChecker(heights);
        assert res == expect: String.format("input=%s, expect %d, but got %d.", 
                Arrays.toString(heights), expect, res);
    }
    
    /**
     * 参考计数排序，将理论上的数与实际上的数比较，返回所有不符合的总数
     * @param heights
     * @return
     */
    public int heightChecker(int[] heights) {
        if(heights == null || heights.length == 0) {
            return 0;
        }
        
        int min = heights[0], max = heights[0];
        int i = 1;
        for(; i < heights.length; i++) {
            if(heights[i] < min) {
                min = heights[i];
            }
            if(heights[i] > max) {
                max = heights[i];
            }
        }
        
        int[] c = new int[max - min + 1];
        for(i = 0; i < heights.length; i++) {
            c[heights[i] - min]++;
        }
        int result = 0, index = 0, count = 0, expect = 0;
        for(i = 0; i < c.length; i++) {
            expect = min + i; // 该位置的理论值
            count = c[i]; // 该位置理论上的人数
            while(count-- > 0) {
                if(heights[index++] != expect) {
                    result++;
                }
            }
        }
        return result;
    }

}

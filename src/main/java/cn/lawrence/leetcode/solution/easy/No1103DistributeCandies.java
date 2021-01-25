package cn.lawrence.leetcode.solution.easy;

import java.util.Arrays;

/**
 * 分糖果2
 */
public class No1103DistributeCandies {
    
    static No1103DistributeCandies sample = new No1103DistributeCandies();
    
    public static void main(String[] args) {
        test(10, 3); // expected: [5,2,3]
        test(21, 3); // expected: [5,7,9]
        test(7, 4); // expected: [1,2,3,1]
        test(60, 4); // expected: [15,18,15,12]
        test(90, 4); // expected: [27,18,21,24]
    }
    
    public static void test(int candies, int people) {
        int[] res = sample.distributeCandies(candies, people);
        System.out.println(Arrays.toString(res));
    }
    
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int c = 0, index = 0;
        for(int i = 0; candies > 0; i++) {
            c = candies >= i + 1 ? i + 1 : candies; // 当前分配的糖果数
            index = i % num_people;
            res[index] = c + res[index];
            candies -= c;
        }
        return res;
    }
}

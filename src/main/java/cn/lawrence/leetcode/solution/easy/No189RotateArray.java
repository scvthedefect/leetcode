package cn.lawrence.leetcode.solution.easy;

import cn.lawrence.leetcode.utils.ArrayUtil;

public class No189RotateArray {
    
    public static void main(String[] args) {
        test(1, 1,2);
        test(3, 2,1);
//        
        test(7, 1);
        test(3, 1,2,3,4,5,6,7);
        test(2, 1,2,3,4,5,6);
//        test(2, 1,2,3,4,5);
    }
    
    public static void test(int k, int...nums) {
        Solution189 s = new Solution189();
        ArrayUtil.printArr("输入：", nums);
        s.rotate(nums, k);
//        s.rotateV1(nums, k);
        System.out.println(String.format("偏移量：%d", k));
        ArrayUtil.printArr("输出：", nums);
        System.out.println("================");
    }
}

class Solution189 {
    
    /**
     * 时间复杂度O(n)，空间复杂度O(n)
     * @param nums
     * @param k
     */
    public void rotateV1(int[] nums, int k) {
        int len = nums.length, i = 0;
        int[] tmp = new int[len];
        for(i = 0; i < len; i++) {
            tmp[(i + k) % len] = nums[i];
        }
        for(i = 0; i < len; i++) {
            nums[i] = tmp[i];
        }
    }
    
    /**
     * 要求空间复杂度为O(1)，采用原地算法
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length <= 1 || (k = k % nums.length) == 0) {
            return;
        }
        
        int modCount = 0;
        for(int start = 0; modCount < nums.length; start++) {
            int current = start;
            int prev = nums[current];
            do {
                int next = (current + k) % nums.length;
                int tmp = nums[next];
                nums[next] = prev;
                current = next;
                prev = tmp;
                modCount++;
            } while(current != start);
        }
    }
}

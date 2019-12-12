package cn.lawrence.leetcode.solution.easy;

public class No303RangeSum {

    public static void main(String[] args) {
        test(0, 2);
        test(2, 5);
        test(0, 5);
    }
    
//    static int[] nums = {-2, 0, 3, -5, 2, -1};
//    static NumArray sample = new NumArray(nums);
    
    static int[] nums = {-2, 0, 3, -5, 2, -1};
    static NumArray2 sample = new NumArray2(nums);
    
    static void test(int i, int j) {
        int result = sample.sumRange(i, j);
        System.out.println(result);
    }
    
}

class NumArray2 {
    
    private int[] accumulate;
    public NumArray2(int[] nums) {
        accumulate = new int[nums.length + 1];
        // accumulate[0]=0, 无需处理
        for(int i = 0; i < nums.length; i++) {
            accumulate[i + 1] = accumulate[i] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        return accumulate[j + 1] - accumulate[i];
    }
}

class NumArray {

    private int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
    }
    
    public int sumRange(int i, int j) {
        if(i >= j) {
            return nums[i];
        }
        
        int mid = i + (j - i) / 2;
        int s1 = sumRange(i, mid);
        int s2 = sumRange(mid + 1, j);
        return s1 + s2;
    }
}
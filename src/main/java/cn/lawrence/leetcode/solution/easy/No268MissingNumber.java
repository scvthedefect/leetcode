package cn.lawrence.leetcode.solution.easy;

/**
 * 缺失数字
 */
public class No268MissingNumber {

    static No268MissingNumber sample = new No268MissingNumber();
    public static void main(String[] args) {
        test(2, 3,0,1);
        test(8, 9,6,4,2,3,5,7,0,1);
    }
    
    public static void test(int expect, int...nums) {
//        int result = sample.missingNumber(nums);
        int result = sample.missingNumberV2(nums);
        System.out.println(expect == result);
    }
    
    public int missingNumber(int[] nums) {
        int[] tmp = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            tmp[nums[i]]++;
        }
        int index = 0;
        for(; index < tmp.length; index++) {
            if(tmp[index] == 0) {
                break;
            }
        }
        return index;
    }
    
    public int missingNumberV2(int[] nums) {
        int len = nums.length;
        int sum = len * (len + 1) / 2; // 理论上由0...n组成的等差数列的和
        for(int i = 0; i < len; i++) {
            sum -= nums[i];
        }
        return sum;
    }

}

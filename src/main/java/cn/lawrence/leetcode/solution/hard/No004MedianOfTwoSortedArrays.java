package cn.lawrence.leetcode.solution.hard;

public class No004MedianOfTwoSortedArrays {
    
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        test(nums1, nums2, 2.0);
        
        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        test(nums3, nums4, 2.5);
        
        int[] nums5 = {};
        int[] nums6 = {2, 3};
        test(nums5, nums6, 2.5);
    }
    
    static No004MedianOfTwoSortedArrays sample = new No004MedianOfTwoSortedArrays();
    public static void test(int[] nums1, int[] nums2, double expected) {
        double res = sample.findMedianSortedArrays(nums1, nums2);
        System.out.println(String.format("expected: %f, result:%f", expected, res));
    }
    
    public double test(int[] nums1, int[] nums2) {
        
        
        
        return 0;
    }
    
    public double findMedianSortedArraysB(int[] nums1, int[] nums2) {
        double res = 0;
        int len = nums1.length + nums2.length;
        int[] tmp;
        if(nums1.length == 0 || nums2.length == 0) {
            tmp = nums1.length == 0 ? nums2 : nums1;
            if(len % 2 == 0) {
                return (tmp[len / 2] + tmp[len / 2 - 1]) / 2.0;
            } else {
                return tmp[len / 2];
            }
        }
        
        int i1 = nums1.length / 2;
        int i2 = (nums2.length - 1) / 2;
        int m1 = nums1[i1]; // 左起的中位数
        int m2 = nums2[i2]; // 右起的中位数
        // S2的中位数从右数起，m1和m2在并集的位置中才必然相邻，如S1=[1,2], S2=[1,2]
        if(m1 == m2) {
            res = m1;
            return res;
        }
        // m1 != m2
        if(m1 > m2) {
            
        }
        
        return res;
    }
    
    /**
     * 返回两个有序数组的中位数
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res = 0;
        int len = nums1.length + nums2.length;
        int index = len / 2;
        int[] tmp;
        
        // 其中一个数组长度为0
        if(nums1.length == 0 || nums2.length == 0) {
            tmp = nums1.length > 0 ? nums1 : nums2;
            if(tmp.length % 2 == 0) {
                res = (tmp[index - 1] + tmp[index]) / 2.0;
            } else {
                res = tmp[index];
            }
            return res;
        }
        
        tmp = new int[len];
        int i = 0, j = 0, k = 0;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] < nums2[j]) {
                tmp[k++] = nums1[i++];
            } else {
                tmp[k++] = nums2[j++];
            }
        }
        
        int[] t;
        if(i == nums1.length) {
            t = nums2;
            i = j;
        } else {
            t = nums1;
        }
        
        while(k <= index) {
            tmp[k++] = t[i++];
        }
        
        if(len % 2 == 0) {
            res = (tmp[index] + tmp[index - 1]) / 2.0;
        } else {
            res = tmp[index];
        }
        return res;
    }

}

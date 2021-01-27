package cn.lawrence.leetcode.solution.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import cn.lawrence.leetcode.common.TreeNode;

/**
 * 两数之和（输入为BST）
 */
public class No653TwoSum {
    
    static Integer[] nums = {5,3,6,2,4,null,7};
    static TreeNode root = new TreeNode(nums);
    static No653TwoSum sample = new No653TwoSum();
    public static void main(String[] args) {
        test(9, true);
        test(28, false);
        test(1, false);
        test(3, false);
    }
    
    public static void test(int k, boolean expt) {
        boolean flag = sample.findTarget(root, k);
        System.out.println(String.format("as expected: %b", flag == expt));
    }
    
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        
        Map<Integer, Integer> map = new HashMap<>();
        int diff = 0, val = 0;
        
        Stack<TreeNode> s = new Stack<>();
        TreeNode n = root;
        while(n != null || !s.isEmpty()) {
            while(n != null) {
                s.push(n);
                n = n.left;
            }
            n = s.pop();
            val = n.val;
            diff = Integer.valueOf(k - val);
            if(map.get(diff) != null) {
                return true;
            } else {
                map.put(val, 0);
            }
            n = n.right;
        }
        return false;
    }

}

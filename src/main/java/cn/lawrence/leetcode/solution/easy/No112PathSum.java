package cn.lawrence.leetcode.solution.easy;

import cn.lawrence.leetcode.common.TreeNode;

/**
 * 路径综合
 */
public class No112PathSum {
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-3);
        TreeNode right = new TreeNode(-2);
        root.right = right;
        
        No112PathSum s = new No112PathSum();
        boolean flag = s.hasPathSum(root, -5);
        System.out.println(flag);
    }
    
    /**
     * 判断根节点到叶节点是否存在等于sum的路径
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        if(root.val == sum && root.left == null && root.right == null) {
            return true;
        }
        int minus = sum - root.val;
        boolean left = hasPathSum(root.left, minus);
        if(left) {
            return true;
        }
        boolean right = hasPathSum(root.right, minus);
        return right;
    }
}

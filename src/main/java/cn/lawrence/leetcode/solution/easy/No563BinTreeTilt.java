package cn.lawrence.leetcode.solution.easy;

import cn.lawrence.leetcode.common.TreeNode;

public class No563BinTreeTilt {
    
    public static void main(String[] args) {
//        Integer[] nums = {1,2,3};
        Integer[] nums = {1,null,3,4,5};
        TreeNode root = new TreeNode(nums);
        int tilt = new No563BinTreeTilt().findTilt(root);
        System.out.println(tilt);
    }
    
    private int tilt;
    public int findTilt(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return tilt;
    }
    
    /**
     * 深度优先遍历
     * @param node
     * @return 返回该子树值的和
     */
    private int dfs(TreeNode node) {
        if(node == null) return 0;
        if(node.left == null && node.right == null) return node.val;
        
        int left = dfs(node.left);
        int right = dfs(node.right);
        tilt += Math.abs(left - right);
        return left + right + node.val;
    }

}

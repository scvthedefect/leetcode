package cn.lawrence.leetcode.solution.easy;

import cn.lawrence.leetcode.common.TreeNode;

/**
 * BST的最小深度
 */
public class No111MinDepthOfBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        root.left = l;
        
        No111MinDepthOfBST s = new No111MinDepthOfBST();
        int depth = s.minDepth(root);
        System.out.println(depth);
    }
    
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return getMinDepth(root);
    }
    
    public int getMinDepth(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int left = getMinDepth(node.left);
        int right = getMinDepth(node.right);
        int depth = 0;
        if(left > 0 && right > 0) {
            depth = Math.min(left, right);
        } else {
            depth = Math.max(left, right);
        }
        return 1 + depth;
    }
    
}

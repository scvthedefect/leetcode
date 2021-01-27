package cn.lawrence.leetcode.solution.easy;

import cn.lawrence.leetcode.common.TreeNode;

/**
 * 判断二叉搜索树是否为AVL树（平衡因子）
 */
public class No110IsAVL {
    
    public static void main(String[] args) {
        
    }
    
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        return depth(root) != -1;
    }
    
    /**
     * 返回节点深度，-1表示BST失衡
     * @param node
     * @return
     */
    public int depth(TreeNode node) {
        if(node == null) {
            return 0;
        }
        if(node.left == null && node.right == null) {
            return 1;
        }
        int left = depth(node.left);
        if(left == -1) {
            return -1;
        }
        int right = depth(node.right);
        if(right == -1) {
            return -1;
        }
        
        if(Math.abs(left - right) > 1) {
            return -1;
        }
        return 1 + Math.max(left, right);
    }
}

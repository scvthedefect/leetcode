package cn.lawrence.leetcode.solution.easy;

import cn.lawrence.leetcode.common.TreeNode;

/**
 * 二叉树的直径：任意两点之间的边数的最大值为二叉树的直径
 */
public class No543DiameterOfBinTree {
    
    int nodes = 1; // 初始化：1（根节点）
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        countNodes(root); // 直径（边数）为节点数减1，故问题转化为求节点数
        return nodes - 1;
    }
    
    public int countNodes(TreeNode node) {
        if(node == null) return 0;
        int left = countNodes(node.left);
        int right = countNodes(node.right);
        nodes = Math.max(nodes, left + right + 1); // 比较当前分支，更新最大节点数
        return Math.max(left, right) + 1; // 返回当前分支的最大节点数
    }

}

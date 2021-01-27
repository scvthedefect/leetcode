package cn.lawrence.leetcode.solution.easy;

import cn.lawrence.leetcode.common.TreeNode;

public class No235LowestCommonAncestorOfBST {
    
    static No235LowestCommonAncestorOfBST sample = new No235LowestCommonAncestorOfBST();

    public static void main(String[] args) {
        
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        int nodeVal = 0, pVal = p.val, qVal = q.val;
        while(node != null) {
            nodeVal = node.val;
            if(p.val > node.val && q.val > node.val) {
                node = node.right;
            } else if(pVal < nodeVal && qVal < nodeVal) {
                node = node.left;
            } else {
                return node;
            }
        }
        return root; // 根节点必为公共祖先
    }
}

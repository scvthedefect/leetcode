package cn.lawrence.leetcode.solution.easy;

import java.util.List;

/**
 * 二叉树是否为镜像
 */
public class No101SymmetricTree {
    
    public static void main(String[] args) {
        test();
    }
    
    public static void test() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;
//        
//        TreeNode n31 = new TreeNode(2);
//        root.left.left = n31;
//        
//        TreeNode n33 = new TreeNode(2);
//        root.right.left = n33;
//        
        No101SymmetricTree s = new No101SymmetricTree();
        boolean flag = s.isSymmetric(root);
        System.out.println(flag);
    }
    
    public void travInOrder(TreeNode node, List<Integer> list) {
        if(node == null) {
            list.add(null);
            return;
        }
        if(node.left == null && node.right == null) {
            list.add(node.val);
            return; // 没有子节点
        }
        
        // 至少有一个子节点
        travInOrder(node.left, list);
        Integer val = node != null ? node.val : null;
        list.add(val);
        travInOrder(node.right, list);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return true;
        }
        if(root.left == null || root.right == null) {
            return false;
        }
        
        return isMirror(root, root);
    }
    
    public boolean isMirror(TreeNode n1, TreeNode n2) {
        if(n1 == null && n2 == null) {
            return true;
        }
        if(n1 == null || n2 == null) {
            return false;
        }
        return (n1.val == n2.val) && isMirror(n1.left, n2.right) && isMirror(n1.right, n2.left);
    }
    
}

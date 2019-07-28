package cn.lawrence.leetcode.solution.easy;

/**
 * 二叉树是否相同
 */
public class No100SameTree {
    
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        n1.left = l1;
        n1.right = r1;
        
        TreeNode n2 = new TreeNode(1);
        TreeNode l2 = new TreeNode(2);
        TreeNode r2 = new TreeNode(3);
        n2.left = l2;
        n2.right = r2;
        
        No100SameTree s = new No100SameTree();
        boolean flag = s.isSameTree(n1, n2);
        System.out.println(flag);
        
    }
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        if(p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}

package cn.lawrence.leetcode.solution.easy;

/**
 * 二叉搜索树的深度
 */
public class No104MaxDepthOfBST {
    
    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(3);
        TreeNode l1 = new TreeNode(9);
        TreeNode r1 = new TreeNode(20);
        root.left = l1;
        root.right = r1;
        
        TreeNode l2 = new TreeNode(15);
        TreeNode r2 = new TreeNode(7);
        root.right.left = l2;
        root.right.right = r2;
        
        No104MaxDepthOfBST s = new No104MaxDepthOfBST();
        int depth = s.maxDepth(root);
        System.out.println(depth);
        
    }
    
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}

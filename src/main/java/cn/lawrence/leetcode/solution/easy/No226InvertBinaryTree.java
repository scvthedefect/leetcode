package cn.lawrence.leetcode.solution.easy;

/**
 * 翻转二叉树
 */
public class No226InvertBinaryTree {

    public static void main(String[] args) {
        
    }
    
    /**
     * 翻转二叉树：顶点不变，左右子树互换
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(root != null) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
    
}

package cn.lawrence.leetcode.solution.easy;

public class No530MinAbsDiffInBST {
    
    static No530MinAbsDiffInBST instance = new No530MinAbsDiffInBST();
    public static void main(String[] args) {
        Integer[] nums = {1,null,3,2};
        TreeNode root = new TreeNode(nums);
        
        int d = instance.getMinimumDifference(root);
        System.out.println(d);
    }
    
    TreeNode prev = null;
    int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if(root == null) return 0;
        inorderTraversal(root);
        return minDiff;
    }
    
    private void inorderTraversal(TreeNode node) {
        if(node == null) return;
        
        inorderTraversal(node.left);
        if(prev != null) {
            minDiff = Math.min(minDiff, Math.abs(node.val - prev.val));
        }
        prev = node;
        inorderTraversal(node.right);
    }
    
}

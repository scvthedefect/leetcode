package cn.lawrence.leetcode.solution.easy;

/**
 * 将已排序数组转换为二叉搜索树（AVL树，平衡因子不超过正负1）
 */
public class No108SortedArrayToBST {
    
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        
        No108SortedArrayToBST s = new No108SortedArrayToBST();
        TreeNode root = s.sortedArrayToBST(nums);
        System.out.println(root.val);
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        TreeNode root = genTree(nums, 0, nums.length - 1);
        return root;
    }
    
    public TreeNode genTree(int[] nums, int left, int right) {
        if(left > right) {
            return null;
        }
        
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = genTree(nums, left, mid - 1);
        node.right = genTree(nums, mid + 1, right);
        return node;
    }
}

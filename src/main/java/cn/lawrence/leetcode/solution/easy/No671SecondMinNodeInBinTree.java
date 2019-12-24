package cn.lawrence.leetcode.solution.easy;

/**
 * 二叉树中第二小的节点
 */
public class No671SecondMinNodeInBinTree {
    
    public static void main(String[] args) {
//        Integer[] nums = {2,2,5,null,null,5,7};
        Integer[] nums = {2,2,2};
        TreeNode root = new TreeNode(nums);
        int sm = new No671SecondMinNodeInBinTree().findSecondMinimumValue(root);
        System.out.println(sm);
    }
    
    /**
     * 问题等价于非根节点的最小值（每个非叶节点的值不大于子节点的值）
     * 
     * 执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :33.7 MB, 在所有 java 提交中击败了82.29%的用户
     * @param root 非空二叉树
     * @return
     */
    int min = 0; // 根节点的值必为最小值
    int secondMin = -1;
    public int findSecondMinimumValue(TreeNode root) {
        min = root.val;
        dfs(root);
        return secondMin;
    }

    private void dfs(TreeNode node) {
        if(node == null) return;
        int val = node.val;
        if(val > min && (secondMin == -1 || val < secondMin)) {
            secondMin = val;
        }
        dfs(node.left);
        dfs(node.right);
    }
    
}

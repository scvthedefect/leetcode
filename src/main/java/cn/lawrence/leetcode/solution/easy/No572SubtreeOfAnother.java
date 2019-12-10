package cn.lawrence.leetcode.solution.easy;

/**
 * 另一个二叉树的子树
 */
public class No572SubtreeOfAnother {
    
    public static void main(String[] args) {
        Integer[] s1 = {1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,2};
        Integer[] t1 = {1,null,1,null,1,null,1,null,1,null,1,2};
        test(s1, t1, true);
        
        Integer[] s2 = {1,1};
        Integer[] t2 = {1};
        test(s2, t2, true);
        
        Integer[] s3 = {3,4,5,1,null,2};
        Integer[] t3 = {3, 1, 2};
        test(s3, t3, false);
    }
    
    static No572SubtreeOfAnother sample = new No572SubtreeOfAnother();
    public static void test(Integer[] n1, Integer[] n2, boolean expect) {
        TreeNode s = new TreeNode(n1);
        TreeNode t = new TreeNode(n2);
        boolean flag = sample.isSubtree(s, t);
        System.out.println(String.format("as expected: %b", (expect == flag)));
    }
    
    /**
     * 分别对左右子节点进行递归
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        return isTheSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    /**
     * 对t进行全量验证
     * @param s
     * @param t
     * @return
     */
    private boolean isTheSame(TreeNode s, TreeNode t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.val != t.val) return false;
        return isTheSame(s.left, t.left) && isTheSame(s.right, t.right);
    }
    
//    public boolean isSubtree(TreeNode s, TreeNode t) {
//        return isSameTree(s, t, t);
//    }
//    
//    private boolean isSameTree(TreeNode s, TreeNode t, TreeNode ori) {
//        if(s == null && t == null) return true;
//        if(s == null || t == null) return false;
//        if(s.val == t.val && isSameTree(s.left, t.left, ori) && isSameTree(s.right, t.right, ori)) return true;
//        return isSameTree(s.left, ori, ori) || isSameTree(s.right, ori, ori);
//    }
}

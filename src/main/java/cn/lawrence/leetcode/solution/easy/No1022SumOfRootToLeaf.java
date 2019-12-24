package cn.lawrence.leetcode.solution.easy;

import java.util.ArrayList;
import java.util.List;

public class No1022SumOfRootToLeaf {

    static No1022SumOfRootToLeaf sample = new No1022SumOfRootToLeaf();
    public static void main(String[] args) {
        Integer[] nums = {1,0,1,0,1,0,1};
        TreeNode root = new TreeNode(nums);
        
//        TreeNode root = null;
        int res = sample.sumRootToLeaf(root);
        System.out.println(String.format("result: %d", res));
    }
    
    int res = 0;
    public int sumRootToLeaf(TreeNode root) {
        if(root == null) {
            return 0;
        }
        dfs(root, 0);
        return res;
    }
    
    private void dfs(TreeNode node, int v) {
        if(node == null) return;
        
        v = (v << 1) + node.val;
        if(node.left == null && node.right == null) {
            res += v;
        } else {
            dfs(node.left, v);
            dfs(node.right, v);
        }
    }
    
//    public int sumRootToLeaf(TreeNode root) {
//        if(root == null) {
//            return 0;
//        }
//        List<String> list = new ArrayList<>();
//        getRoute(root, "", list);
//        
//        int res = 0;
//        Integer n;
//        for(String s : list) {
//            n = Integer.valueOf(s, 2);
//            res += n.intValue();
//        }
//        return res;
//    }
//    
//    private void getRoute(TreeNode node, String val, List<String> list) {
//        if(node == null) {
//            return;
//        }
//        
//        val += node.val;
//        if(node.left == null && node.right == null) {
//            list.add(val);
//        } else {
//            getRoute(node.left, val, list);
//            getRoute(node.right, val, list);
//        }
//    }
    
}

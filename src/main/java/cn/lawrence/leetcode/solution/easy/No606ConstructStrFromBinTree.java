package cn.lawrence.leetcode.solution.easy;

import cn.lawrence.leetcode.common.TreeNode;

/**
 * 根据二叉树创建字符串
 */
public class No606ConstructStrFromBinTree {
    
    public static void main(String[] args) {
        Integer[] n1 = {1,2,3,4};
        test(n1);
        Integer[] n2 = {1,2,3,null,4};
        test(n2);
        Integer[] n3 = {1};
        test(n3);
        Integer[] n4 = {1,null,2,null,3,null,4,null,5,null,6};
        test(n4);
    }
    
    public static void test(Integer[] nums) {
        TreeNode root = new TreeNode(nums);
        String s = new No606ConstructStrFromBinTree().tree2str(root);
        System.out.println(s);
    }
    
    public String tree2strOfficial(TreeNode t) {
        if(t == null) return "";
        if(t.left == null && t.right == null) return String.valueOf(t.val); 
        if(t.left == null) return String.valueOf(t.val) + "()(" + tree2strOfficial(t.right) + ")";
        if(t.right == null) return String.valueOf(t.val) + "(" + tree2strOfficial(t.left) + ")";
        return String.valueOf(t.val) + "(" + tree2strOfficial(t.left) + ")(" + tree2strOfficial(t.right) + ")";
    }

    public String tree2str(TreeNode t) {
        if(t == null) return "";
        String s = preorder(t);
        s = s.substring(1, s.length() - 1);
        return s;
    }
    
    String template = "(%d%s%s)";
    private String preorder(TreeNode n) {
        if(n == null) return "";
        String left = "";
        String right = "";
        if(n.left != null || n.right != null) {            
            left = n.left != null ? preorder(n.left) : "()";
            right = n.right != null ? preorder(n.right) : "";
        }
        String s = String.format(template, n.val, left, right);
        return s;
    }
    
}

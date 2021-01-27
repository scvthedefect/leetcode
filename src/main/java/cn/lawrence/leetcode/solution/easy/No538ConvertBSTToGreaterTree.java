package cn.lawrence.leetcode.solution.easy;

import java.util.List;
import java.util.Stack;

import cn.lawrence.leetcode.common.TreeNode;
import cn.lawrence.leetcode.common.TreeNode.Order;

public class No538ConvertBSTToGreaterTree {
    
    static No538ConvertBSTToGreaterTree sample = new No538ConvertBSTToGreaterTree();
    public static void main(String[] args) {
        Integer[] nums = {5,2,13};
//        Integer[] nums = {2,0,3,-4,1};
        TreeNode root = new TreeNode(nums);
        root = sample.convertBST(root);
        
        List<Integer> list = root.traversal(Order.IN_ORDER);
        System.out.println(list.toString());
    }
    
    int accumulate = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null) {
            return root;
        }
        convertBST(root.right);
        root.val += accumulate;
        accumulate = root.val;
        convertBST(root.left);
        return root;
    }

    public TreeNode convertBST_V1(TreeNode root) {
        if(root == null) {
            return root;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        inorder(root, stack);
        TreeNode node = stack.pop();
        int accumulate = node.val;
        while(!stack.isEmpty()) {
            node = stack.pop();
            accumulate += node.val;
            node.val = accumulate;
        }
        return root;
        
    }
    
    public void inorder(TreeNode node, Stack<TreeNode> stack) {
        if(node == null) {
            return;
        }
        
        inorder(node.left, stack);
        stack.add(node);
        inorder(node.right, stack);
    }
    
}

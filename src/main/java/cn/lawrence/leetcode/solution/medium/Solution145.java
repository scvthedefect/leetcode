package cn.lawrence.leetcode.solution.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import cn.lawrence.leetcode.common.TreeNode;

public class Solution145 {
    
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1, null, 2, 3);
//        TreeNode root = new TreeNode(1, 2, 3, 4, 5, 6, 7);
//        TreeNode root = new TreeNode(1);
        TreeNode root = null;
        List<Integer> result = new Solution145().postorderTraversal(root);
        System.out.println(result.toString());
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        
        TreeNode current, left, right;
        TreeNode prev = null;
        
        boolean isHandled = false, isLeaf = false;
        Integer val;
        while (!stack.isEmpty()) {
            current = stack.peek();
            left = current.left;
            right = current.right;
            
            isLeaf = left == null && right == null;
            isHandled = prev != null && (left == prev || right == prev);
            prev = current;
            if (isLeaf || isHandled) {
                val = Integer.valueOf(current.val);
                result.add(val);
                stack.pop();
                continue;
            }
            
            if (right != null) {
                stack.push(right);
            }
            if (left != null) {
                stack.push(left);
            }
        }
        return result;
    }

}

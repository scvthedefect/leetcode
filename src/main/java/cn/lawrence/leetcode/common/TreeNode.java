package cn.lawrence.leetcode.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    
    public int val;
    
    public TreeNode left;
    
    public TreeNode right;
    
    public TreeNode(int x) {
        val = x;
    }
    
    public TreeNode(Integer...nums) {
        Queue<TreeNode> q = new LinkedList<>();
        
        Integer v;
        TreeNode parent = null;
        TreeNode node;
        for(int i = 0; i < nums.length; i++) {
            v = nums[i]; // v could be null.
            if(i == 0) { // root node.
                this.val = v.intValue();
                q.add(this);
                continue;
            }
            
            node = v == null ? null : new TreeNode(v.intValue());
            if(i % 2 == 1) { // left node.
                parent = q.poll();
                parent.left = node;
            } else { // right node.
                parent.right = node;
            }
            
            if(node != null) {
                q.add(node);
            }
        }
    }
    
    /**
     * 遍历二叉树
     * @param order
     * @return
     */
    public List<Integer> traversal(Order order) {
        List<Integer> list = new ArrayList<>();
        switch (order) {
        case PRE_ORDER:
            preOrder(this, list);
            break;
        case IN_ORDER:
            inOrder(this, list);
            break;
        case POST_ORDER:
            postOrder(this, list);
            break;
        case LEVEL_ORDER:
            levelOrder(list);
            break;
        default:
            break;
        }
        return list;
    }
    
    private void inOrder(TreeNode node, List<Integer> list) {
        if(node == null) return;
        if(node.left != null) inOrder(node.left, list);
        list.add(node.val);
        if(node.right != null) inOrder(node.right, list);
    }
    
    private void preOrder(TreeNode node, List<Integer> list) {
        if(node == null) return;
        list.add(node.val);
        if(node.left != null) preOrder(node.left, list);
        if(node.right != null) preOrder(node.right, list);
    }
    
    private void postOrder(TreeNode node, List<Integer> list) {
        if(node == null) return;
        if(node.left != null) postOrder(node.left, list);
        if(node.right != null) postOrder(node.right, list);
        list.add(node.val);
    }
    
    private void levelOrder(List<Integer> list) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(this);
        TreeNode node;
        while(!q.isEmpty()) {
            node = q.poll();
            list.add(node.val);
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
        }
    }
    
    public enum Order {
        /**
         * 先序遍历
         */
        PRE_ORDER, 
        
        /**
         * 中序遍历
         */
        IN_ORDER,
        
        /**
         * 后序遍历
         */
        POST_ORDER,
        
        /**
         * 层次遍历
         */
        LEVEL_ORDER,
    }
    
}

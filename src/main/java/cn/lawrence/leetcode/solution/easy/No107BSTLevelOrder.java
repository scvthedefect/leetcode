package cn.lawrence.leetcode.solution.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的层次遍历(自底往上)
 */
public class No107BSTLevelOrder {
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode l1 = new TreeNode(9);
        TreeNode r1 = new TreeNode(20);
        root.left = l1;
        root.right = r1;
        TreeNode l2 = new TreeNode(15);
        TreeNode r2 = new TreeNode(7);
        r1.left = l2;
        r1.right = r2;
        
        No107BSTLevelOrder s = new No107BSTLevelOrder();
        List<List<Integer>> list = s.levelOrderBottom(root);
        System.out.println(list.toString());
    }
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(root);
        
        Queue<TreeNode> curr = q1;
        while(!curr.isEmpty()) {
            Queue<TreeNode> tmp = curr == q1 ? q2 : q1;
            List<Integer> layer = new ArrayList<>();
            while(!curr.isEmpty()) {
                TreeNode node = curr.poll();
                layer.add(node.val);
                if(node.left != null) {                    
                    tmp.add(node.left);
                }
                if(node.right != null) {                    
                    tmp.add(node.right);
                }
            }
            list.add(layer);
            curr = tmp;
        }
        Collections.reverse(list);
        return list;
    }

}

package cn.lawrence.leetcode.solution.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import cn.lawrence.leetcode.solution.easy.TreeNode;

/**
 * BST 层次遍历
 */
public class No102BSTLevelOrderTraversal {
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode l1 = new TreeNode(9);
        TreeNode r1 = new TreeNode(20);
        root.left = l1;
        root.right = r1;
        TreeNode l2 = new TreeNode(15);
        TreeNode r2 = new TreeNode(7);
        root.right.left = l2;
        root.right.right = r2;
        
//        List<List<Integer>> list = new No102BSTLevelOrderTraversal().levelOrderV1(root);
        List<List<Integer>> list = new No102BSTLevelOrderTraversal().levelOrderV2(root);
        System.out.println(list.toString());
    }
    
    public List<List<Integer>> levelOrderV2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 1;
        List<Integer> tmp;
        TreeNode node;
        while(!queue.isEmpty()) {
            tmp = new ArrayList<>();
            while(count-- > 0) {
                node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(tmp);
            count = queue.size();
        }
        return list;
    }

    public List<List<Integer>> levelOrderV1(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        
        Queue<TreeNode> queue = q1;
        queue.add(root);
        Queue<TreeNode> tmp;
        
        List<Integer> t;
        TreeNode node;
        while(!queue.isEmpty()) {
            tmp = queue == q1 ? q2 : q1;
            
            t = new ArrayList<>();
            while((node = queue.poll()) != null) {
                t.add(node.val);
                if(node.left != null) {
                    tmp.add(node.left);
                }
                if(node.right != null) {
                    tmp.add(node.right);
                }
            }
            list.add(t);
            queue = tmp;
        }
        return list;
    }
}

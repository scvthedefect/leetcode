package cn.lawrence.leetcode.solution.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import cn.lawrence.leetcode.solution.easy.TreeNode;

/**
 * 二叉树的中序遍历（迭代）
 */
public class No094BinTreeInorderTraversal {
    
    public static void main(String[] args) {
        Integer[] nums = {1,null,2,3};
        TreeNode root = new TreeNode(nums);
        List<Integer> list = new No094BinTreeInorderTraversal().inorderTraversal(root);
        System.out.println(list.toString());
    }
    
    public List<Integer> inorderV2(TreeNode root) {
        if(root == null) return Collections.emptyList();
        
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode n = root;
        while(n != null || !s.isEmpty()) {
            while(n != null) {
                s.push(n);
                n = n.left;
            }
            n = s.pop();
            list.add(Integer.valueOf(n.val));
            n = n.right;
        }
        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        s.add(root);
        Map<TreeNode, Integer> map = new HashMap<>(); // 记录已处理的节点
        TreeNode n;
        while(!s.isEmpty()) {
            n = s.pop();
            if((n.left == null && n.right == null) || map.get(n) != null) {
                list.add(n.val);
                continue;
            }
            if(n.right != null) s.add(n.right);
            s.add(n);
            if(n.left != null) s.add(n.left);
            map.put(n, 1); // 非叶节点需要记录为已处理
        }
        return list;
    }
    
}

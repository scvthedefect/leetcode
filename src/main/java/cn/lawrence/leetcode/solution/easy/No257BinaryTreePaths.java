package cn.lawrence.leetcode.solution.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cn.lawrence.leetcode.common.TreeNode;

/**
 * 二叉树的所有路径
 */
public class No257BinaryTreePaths {
    
    static No257BinaryTreePaths sample = new No257BinaryTreePaths();
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        root.left = l1;
        root.right = r1;
        TreeNode r2 = new TreeNode(5);
        l1.left = r2;
        
        List<String> list = new No257BinaryTreePaths().binaryTreePaths(root);
        System.out.println(list.toString());
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) {
            return Collections.emptyList();
        }
        List<String> list = new ArrayList<>();
        getPath(root, list, "");
        return list;
    }
    
    public void getPath(TreeNode node, List<String> list, String path) {
        if(node == null) {
            return;
        }
        
        path += Integer.toString(node.val);
        if(node.left == null && node.right == null) { // is leaf
            list.add(path);
        } else {
            path += "->";
            getPath(node.left, list, path);
            getPath(node.right, list, path);
        }
    }
    
}

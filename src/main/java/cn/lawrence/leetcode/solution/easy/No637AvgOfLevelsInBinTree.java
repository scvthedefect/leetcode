package cn.lawrence.leetcode.solution.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层平均值
 */
public class No637AvgOfLevelsInBinTree {
    
    public static void main(String[] args) {
        Integer[] nums = {3,9,20,null,null,15,7};
        TreeNode root = new TreeNode(nums);
        List<Double> list = new No637AvgOfLevelsInBinTree().averageOfLevels(root);
        System.out.println(list.toString());
    }
    
    /**
     * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null) return Collections.emptyList();
        
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int counter = 1;
        TreeNode node;
        double avg;
        int n;
        while(!queue.isEmpty()) {
            avg = 0;
            n = counter;
            while(counter > 0) {
                node = queue.poll();
                avg += node.val;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                if(--counter == 0) {
                    avg /= n;
                    list.add(avg);
                }
            }
            counter = queue.size();
        }
        return list;
    }

}

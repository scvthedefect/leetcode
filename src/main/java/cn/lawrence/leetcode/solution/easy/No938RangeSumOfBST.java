package cn.lawrence.leetcode.solution.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * BST的范围和
 */
public class No938RangeSumOfBST {
    
    public static void main(String[] args) {
        No938RangeSumOfBST instance = new No938RangeSumOfBST();
        
        Integer[] n1 = {10,5,15,3,7,null,18};
        int l1 = 7, r1 = 15;
        TreeNode node1 = new TreeNode(n1);
        int n = instance.rangeSumBST(node1, l1, r1);
        System.out.println(n);
        
        Integer[] n2 = {10,5,15,3,7,13,18,1,null,6};
        int l2 = 6, r2 = 10;
        TreeNode node2 = new TreeNode(n2);
        n = instance.rangeSumBST(node2, l2, r2);
        System.out.println(n);
    }
    
    public int rangeSumBST(TreeNode root, int L, int R) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode n = root;
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        while(n != null || !s.isEmpty()) {
            while(n != null) {
                s.push(n);
                n = n.left;
            }
            n = s.pop();
            list.add(n.val);
            n = n.right;
        }
        int i = 0, j = list.size() - 1;
        while(list.get(i) < L) {
            i++;
        }
        while(list.get(j) > R) {
            j--;
        }
        while(i <= j) {
            if(i < j) {
                sum += list.get(i++);
                sum += list.get(j--);
            } else if(i == j) {
                sum += list.get(i++);
            }
        }
        return sum;
    }
    
}

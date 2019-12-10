package cn.lawrence.leetcode.solution.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * n叉树的层次遍历
 */
public class No429TreeTraversal {
    
    static No429TreeTraversal sample = new No429TreeTraversal();

    public static void main(String[] args) {
        Node fifth = new Node(5, null);
        Node sixth = new Node(6, null);
        List<Node> l3 = Arrays.asList(fifth, sixth);
        Node third = new Node(3, l3);
        Node second = new Node(2, null);
        Node forth = new Node(4, null);
        List<Node> l2 = Arrays.asList(third, second, forth);
        Node root = new Node(1, l2);
        
//        List<List<Integer>> list = sample.levelOrder(root);
        List<List<Integer>> list = sample.levelOrder_V2(root);
        System.out.println(list.toString());
    }
    
    public List<List<Integer>> levelOrder_V2(Node root) {
        if(root == null) {
            return Collections.emptyList();
        }
        
        List<List<Integer>> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            
            int count = q.size();
            while(count-- > 0) {
                Node node = q.poll();
                tmp.add(node.val);
                if(node.children != null && !node.children.isEmpty()) {
                    q.addAll(node.children);
                }
            }
            list.add(tmp);
        }
        return list;
    }
    
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null) {
            return Collections.emptyList();
        }
        
        List<List<Integer>> list = new ArrayList<>();
        Queue<Node> curr = new LinkedList<>();
        Queue<Node> back = new LinkedList<>();
        curr.add(root);
        while(!curr.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            while(!curr.isEmpty()) {
                Node node = curr.poll();
                tmp.add(node.val);
                
                if(node.children != null && !node.children.isEmpty()) {
                    back.addAll(node.children);
                }
            }
            list.add(tmp);
            
            Queue<Node> t = curr;
            curr = back;
            back = t;
        }
        return list;
    }
    
}

class Node {
    
    public int val;
    
    public List<Node> children;
    
    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
    
}

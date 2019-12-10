package cn.lawrence.leetcode.solution.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class No590PostorderTraversal {

    public static void main(String[] args) {
        List<Node> v3l = Arrays.asList(new Node(5, null), new Node(6, null));
        List<Node> v2l = Arrays.asList(new Node(3, v3l), new Node(2, null), new Node(4, null));
        Node root = new Node(1, v2l);
        
        List<Integer> list = new No590PostorderTraversal().postorderB(root);
        System.out.println(list.toString());
    }
    
    public List<Integer> postorderB(Node root) {
        if(root == null) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.add(root);
        Node n;
        int i;
        while(!s1.isEmpty()) {
            n = s1.pop();
            if(n.children != null) {
                for(i = 0; i < n.children.size(); i++) {
                    s1.add(n.children.get(i));
                }
            }
            s2.add(n);
        }
        while(!s2.isEmpty()) {
            list.add(s2.pop().val);
        }
        return list;
    }
    
    public List<Integer> postorderA(Node root) {
        if(root == null) {
            return Collections.emptyList();
        }
        
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list;
    }
    
    public void traversal(Node node, List<Integer> list) {
        if(node == null) {
            return;
        }
        if(node.children != null) {
            for(Node n : node.children) {
                traversal(n, list);
            }
        }
        list.add(node.val);
    }
    
}

package cn.lawrence.leetcode.solution.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class No589PreorderTraversal {

    public static void main(String[] args) {
        List<Node> v3l = Arrays.asList(new Node(5, null), new Node(6, null));
        List<Node> v2l = Arrays.asList(new Node(3, v3l), new Node(2, null), new Node(4, null));
        Node root = new Node(1, v2l);
        
//        List<Integer> res = new No589PreorderTraversal().preorderA(root);
        List<Integer> res = new No589PreorderTraversal().preorderB(root);
        System.out.println(res.toString());
    }
    
    /**
     * 版本B:循环
     * @param root
     * @return
     */
    public List<Integer> preorderB(Node root) {
        if(root == null) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        Node n;
        int i;
        while(!stack.isEmpty()) {
            n = stack.pop();
            list.add(n.val);
            
            if(n.children != null) {
                for(i = n.children.size() - 1; i >= 0; i--) {
                    stack.add(n.children.get(i));
                }
            }
        }
        return list;
    }
    
    /**
     * 版本A:递归
     * @param root
     * @return
     */
    public List<Integer> preorderA(Node root) {
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
        list.add(node.val);
        if(node.children != null) {
            for(Node n : node.children) {
                traversal(n, list);
            }
        }
    }
    
}

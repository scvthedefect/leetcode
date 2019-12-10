package cn.lawrence.leetcode.solution.easy;

/**
 * n叉树的最大深度（即树高）
 */
public class No559MaxDepth {
    
    public int maxDepth(Node root) {
        return getDepth(root);
    }
    
    public int getDepth(Node n) {
        if(n == null) {
            return 0;
        }
        
        int maxDepth = 0;
        if(n.children != null) {
            int depth;
            for(int i = 0; i < n.children.size(); i++) {
                depth = getDepth(n.children.get(i));
                maxDepth = depth > maxDepth ? depth : maxDepth;
            }
        }
        return maxDepth + 1;
    }
    
}

package cn.lawrence.leetcode.solution.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No022GenerateParenthesis {

    public static void main(String[] args) {
        int n = 3;
        
        Solution022 s = new Solution022();
        List<String> list = s.generateParenthesis(n);
        System.out.println(list.toString());
    }
    
}

class Solution022 {
    
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if(n <= 0) {
            return list;
        }
        
        Stack<String> stack = new Stack<>();
        
        return list;
    }
    
}

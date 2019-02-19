package cn.lawrence.leetcode.within100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No020ValidParentheses {

    public static void main(String[] args) {
        
        test("()", true);
        test("(())", true);
        test("()[]{}", true);
        test("(]", false);
        test("({}[]())", true);
        test("((])", false);
        test("([)]", false);
        test("{[]}", true);
        
        test("]", false);
        test("", true);
        test("(])", false);
        
    }
    
    public static void test(String s, boolean expected) {
        solution020 obj = new solution020();
//        boolean isValid = obj.isValid(s);
        boolean isValid = obj.isValidModified(s);
        System.out.println(String.format("input: %s, expected: %b, isValid: %b, isMatched: %b", s, expected, isValid, (isValid == expected)));
    }
    
}

class solution020 {
    
    public boolean isValid(String s) {
        if(s == null || s.trim().length() == 0) {
            return true;
        }
        
        boolean result = false;
        Stack<Character> stack = new Stack<>();
        
        try {
            for(char c : s.toCharArray()) {
                boolean isInsert = c == '(' || c == '[' || c == '{';
                if(isInsert) {
                    stack.push(c);
                    continue;
                }
                
                if(c == ')' && stack.pop() == '(') {
                    continue;
                }
                
                if(c == ']' && stack.pop() == '[') {
                    continue;
                }
                
                if(c == '}' && stack.pop() == '{') {
                    continue;
                }
                
                boolean isCheck = c == ')' || c == ']' || c == '}';
                if(isCheck) {
                    return false;
                }
            }
            result = stack.isEmpty();
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
    
    public boolean isValidModified(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }
        
        boolean isValid = false;
        List<Character> list = new ArrayList<>(s.length());
        
        for(char c : s.toCharArray()) {
            boolean isAdd = c == '(' || c == '[' || c == '{';
            if(isAdd) {
                list.add(c);
                continue;
            }
            
            boolean isCheck = c == ')' || c == ']' || c == '}';
            if(isCheck) {
                int index = list.size() - 1;
                if(index < 0) {
                    return false;
                }
                
                char compare = list.get(index);
                boolean isMatch = (c == ')' && compare == '(')
                        || (c == ']' && compare == '[')
                        || (c == '}' && compare == '{');
                if(isMatch) {
                    list.remove(index);
                    continue;
                } else {
                    return false;
                }
            }
        }
        
        isValid = list.isEmpty();
        return isValid;
    }
    
}
package cn.lawrence.leetcode.solution.easy;

import java.util.Stack;

public class No682BaseballGame {
    
    public static void main(String[] args) {
        No682BaseballGame entity = new No682BaseballGame();
        
//        String[] ops = {"5","2","C","D","+"};
        String[] ops = {"5","-2","4","C","D","9","+","+"};
        int result = entity.calPoints(ops);
        System.out.println(result);
    }
    
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        Integer i, j, k;
        for (String str : ops) {
            switch (str) {
            case "C":
                stack.pop();
                break;
            case "D":
                i = stack.pop();
                j = i * 2;
                stack.push(i);
                stack.push(j);
                break;
            case "+":
                i = stack.pop();
                j = stack.pop();
                k = i + j;
                stack.push(j);
                stack.push(i);
                stack.push(k);
                break;
            default:
                stack.push(Integer.valueOf(str));
                break;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            i = stack.pop();
            result += i.intValue();
        }
        return result;
    }

}

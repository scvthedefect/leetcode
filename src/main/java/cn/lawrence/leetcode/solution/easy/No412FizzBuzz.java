package cn.lawrence.leetcode.solution.easy;

import java.util.ArrayList;
import java.util.List;

public class No412FizzBuzz {
    
    static No412FizzBuzz sample = new No412FizzBuzz();
    
    public static void main(String[] args) {
        test(0);
        test(2);
        test(3);
        test(5);
        test(10);
        test(15);
    }
    
    public static void test(int n) {
        List<String> list = sample.fizzBuzz(n);
        System.out.println(list.toString());
    }
    
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        if(n <= 0) {
            return list;
        }
        for(int i = 1; i <= n; i++) {
            String s = null;
            if(i % 3 == 0) {
                s = "Fizz";
            }
            if(i % 5 == 0) {
                s = s == null ? "Buzz" : s + "Buzz";
            }
            if(s == null) {
                s = i + "";
            }
            list.add(s);
        }
        return list;
    }

}

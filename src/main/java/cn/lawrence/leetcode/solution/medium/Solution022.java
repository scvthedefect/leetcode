package cn.lawrence.leetcode.solution.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution022 {
    
    public static void main(String[] args) {
        Solution022 solution = new Solution022();
        int n = 4;
//        int n = 3;
        
        List<String> list = solution.generateParenthesis(n);
        System.out.println(list.toString());
        System.out.println(list.size());
    }
    
    private static List<String> first = Arrays.asList("()");
    private static Map<Integer, Collection<String>> container = null;
    
    private static Map<Integer, Collection<String>> getContainer() {
        if (container == null) {
            container = new HashMap<>();
            container.put(Integer.valueOf(1), first);
        }
        return container;
    }
    
    /**
     * 
     * @param n 1 <= n <= 8
     * @return
     */
    public List<String> generateParenthesis(int n) {
        if (n == 1) {
            return first;
        }
        Map<Integer, Collection<String>> map = getContainer();
        int p = n - 1;
        Collection<String> prev = map.get(Integer.valueOf(p));
        if (prev == null) {
            prev = generateParenthesis(p);
        }
        
        Set<String> set = new HashSet<>();
        for (String str : prev) {
            process(str, set);
        }
        
        map.put(Integer.valueOf(n), set);
        return new ArrayList<>(set);
    }
    
    private void process(String str, Set<String> set) {
        String s = "(" + str;
        char[] c;
        char[] ori = s.toCharArray();
        int size = s.length() + 1;
        String tmp;
        int a, b;
        for (int i = 1; i < size; i++) {
            a = 0;
            b = 0;
            c = new char[size];
            while (b < size) {
                if (b != i) {
                    c[b++] = ori[a++];
                } else {
                    c[b++] = ')';
                }
            }
            tmp = new String(c);
            set.add(tmp);
        }
    }
}

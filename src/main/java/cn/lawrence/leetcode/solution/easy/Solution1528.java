package cn.lawrence.leetcode.solution.easy;

public class Solution1528 {
    
    public static void main(String[] args) {
        Solution1528 solution = new Solution1528();
        
//        String s = "codeleet";
//        int[] indices = {4,5,6,7,0,2,1,3};
        
//        String s = "aiohn";
//        int[] indices = {3,1,4,2,0};
        
//        String s = "aaiougrt";
//        int[] indices = {4,0,2,6,7,3,1,5};
        
        String s = "";
        int[] indices = {};
        
        String res = solution.restoreString(s, indices);
        System.out.println(res);
    }
    
    public String restoreString(String s, int[] indices) {
        char[] c = new char[s.length()];
        int j = 0;
        for (int i : indices) {
            c[i] = s.charAt(j++);
        }
        return new String(c);
    }

}

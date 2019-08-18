package cn.lawrence.leetcode.solution.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Bigram 分词
 */
public class No1078Bigram {
    
    static No1078Bigram sample = new No1078Bigram();
    
    public static void main(String[] args) {
        test("alice is a good girl she is a good student", "a", "good");
        test("we will we will rock you", "we", "will");
        test("", "", "");
    }
    
    public static void test(String text, String first, String second) {
        String[] result = sample.findOcurrences(text, first, second);
        System.out.println(Arrays.toString(result));
    }

    public String[] findOcurrences(String text, String first, String second) {
        String[] arr = text.split(" ");
        List<String> list = new ArrayList<>();
        for(int i = 0; i < arr.length - 2; i++) {
            if(arr[i].equals(first) && arr[i + 1].equals(second)) {
                list.add(arr[i + 2]);
            }
        }
        String[] res = new String[list.size()];
        list.toArray(res);
        return res;
    }
    
}

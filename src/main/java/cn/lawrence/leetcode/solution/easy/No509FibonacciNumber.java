package cn.lawrence.leetcode.solution.easy;

public class No509FibonacciNumber {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        
        //     n=[0,1,2,3,4,5,6,7,...,43]
        //fib(n)=[0,1,1,2,3,5,8,13,...,433494437] 
        
        Solution509 s = new Solution509();
//        int res = s.fibModified(43);
        int res = s.fibV2(43);
        System.out.println(res);
        
        long end = System.currentTimeMillis();
        System.out.println(String.format("耗时: %d ms.", (end - start)));
    }
    
    public static void test(int n) {
        Solution509 s = new Solution509();
        int check = s.fib(n);
        int res = s.fibModified(n);
        System.out.println(String.format("input: %d, expect: %d, as expected: %b",
                n, check, (res == check)));
    }
    
}

class Solution509 {
    
    public int fib(int N) {
        int[] arr = new int[N + 1];
        for(int i = 0; i < N + 1; i++) {
            if(i == 0) {
                arr[i] = 0;
            } else if(i == 1) {
                arr[i] = 1;
            } else {
                arr[i] = arr[i - 1] + arr[i - 2];
            }
        }
        return arr[N];
    }
    
    public int fibModified(int n) {
        int curr = 0, next = 1;
        while(n-- > 0) {
            next = next + curr;
            curr = next - curr;
        }
        return curr;
    }
    
    public int fibV2(int N) {
        int curr = 0, next = 1, tmp = 0;
        while(N-- > 0) {
            tmp = next;
            next = curr + next;
            curr = tmp;
        }
        return curr;
    }
    
}

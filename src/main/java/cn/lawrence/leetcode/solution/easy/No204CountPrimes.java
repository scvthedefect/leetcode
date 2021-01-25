package cn.lawrence.leetcode.solution.easy;

/**
 * 统计
 * 正整数n以内的质数数量
 */
public class No204CountPrimes {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Solution204 s = new Solution204();
        int count = s.countPrimes(999983);
        System.out.println(count);
        
        long end = System.currentTimeMillis();
        System.out.println(String.format("耗时：%d ms.", (end - start)));
    }
    
    /**
     * 统计所有小于非负整数n的质数的数量
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if(n == 1) {
            return 1;
        }
        if(n < 1) {
            return 0;
        }
        
        int count = 0; // 不包含1
        while(n-- > 1) {
            if(n % 5 == 0) {
                
            }
        }
        return count;
    }
    
}

class Solution204 {
    
    public int countPrimes(int n) {
        int count = 0;
        if(n <= 1) {
            return count;
        }
        
        boolean isPrimeNum = true;
        int temp = 0;
        while(n-- > 2) {
            isPrimeNum = true;
            if(n > 2 && n % 2 == 0) { // 大于2的偶数必为合数
                isPrimeNum = false;
            } else { // 否则使用试除法验证是否为质数
                temp = (int) Math.sqrt(n);
                while(temp > 1) {
                    if(n % temp == 0) {
                        isPrimeNum = false;
                        break;
                    }
                    temp--;
                }
            }
            count = isPrimeNum ? ++count : count;
        }
        return count;
    }
    
}

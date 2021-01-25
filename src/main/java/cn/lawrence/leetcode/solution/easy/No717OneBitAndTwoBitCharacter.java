package cn.lawrence.leetcode.solution.easy;

public class No717OneBitAndTwoBitCharacter {
    
    public static void main(String[] args) {
        
        
    }
    
    /**
     * 1 <= len(bits) <= 1000
     * bits[i] 的值为0或1
     * bits总是以0结束
     * @param bits
     * @return
     */
    public boolean isOneBitCharacter(int[] bits) {
        int index = -1;
        for(int i = bits.length - 1; i >= 0; i--) {
            if(bits[i] == 1) {
                index = i;
                break;
            }
        }
        if(index == -1) {
            return true;
        } else if(index != bits.length - 2) {
            return true;
        }
        return false;
    }
    
    /**
     * 标准做法，通过由前向后遍历
     * @param bits
     * @return
     */
    public boolean normal(int[] bits) {
        int i = 0;
        while(i < bits.length) {
            i += bits[i] + 1;
        }
        return i == (bits.length - 1);
    }

}

package cn.lawrence.leetcode.solution.easy;

public class No1108IPAddr {
    
    static No1108IPAddr sample = new No1108IPAddr();
    public static void main(String[] args) {
        test("1.1.1.1");
        
        String s = "1.1.1.1";
        String[] ss = s.split("\\.");
        System.out.println(ss.length);
        
    }
    
    public static void test(String address) {
        String s = sample.defangIPaddr(address);
        System.out.println(String.format("address: %s, result: %s", address, s));
    }
    
    /**
     * @param address 有效的ip地址
     * @return
     */
    public String defangIPaddr(String address) {
//        return address.replace(".", "[.]");
        
        String[] s = address.split("\\.");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length; i++) {
            if(i != 0) {
                sb.append("[.]");
            }
            sb.append(s[i]);
        }
        return sb.toString();
    }

}

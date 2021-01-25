package cn.lawrence.leetcode.solution.easy;

/**
 * 买卖股票的最佳时机
 */
public class No121BuyAndSellStock {
    
    public static void main(String[] args) {
        No121BuyAndSellStock s = new No121BuyAndSellStock();
//        int[] prices = {7,1,5,3,6,4};
        int[] prices = {7,6,4,3,1};
//        int profit = s.maxProfit(prices);
        int profit = s.maxProfit2(prices);
        System.out.println(profit);
    }
    
    public int maxProfit2(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int maxProfit = 0, minPrice = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
    
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int maxProfit = 0, i = 0, j = 0, tmp = 0;
        for(i = 0; i < prices.length; i++) {
            for(j = i + 1; j < prices.length; j++) {
                tmp = prices[j] - prices[i];
                maxProfit = tmp > maxProfit ? tmp : maxProfit;
            }
        }
        return maxProfit;
    }

}

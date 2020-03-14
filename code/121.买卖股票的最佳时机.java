/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int curmin = prices[0];
        int max = Integer.MIN_VALUE;
        for(int p:prices){
            max = Math.max(max, p-curmin);
            curmin = Math.min(curmin,p);
        }
        return max;
    }
}
// @lc code=end


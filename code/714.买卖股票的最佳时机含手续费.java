/*
 * @lc app=leetcode.cn id=714 lang=java
 *
 * [714] 买卖股票的最佳时机含手续费
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        // if (n==0) return 0;
        int dp_i_0 = 0;
        int dp_i_1 = -prices[0];
        for (int i = 1; i <n; i++) {
            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_1+prices[i]-fee, dp_i_0);
            dp_i_1 = Math.max(tmp-prices[i], dp_i_1);
        }
        return dp_i_0;
    }
}
// @lc code=end


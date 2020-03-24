/*
 * @lc app=leetcode.cn id=188 lang=java
 *
 * [188] 买卖股票的最佳时机 IV
 */

// @lc code=start
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0)
            return 0;
        if (k > n / 2)
            return maxProfit(prices);
        int[][] dp = new int[k+1][2];
        for (int i = 0; i <= k; i++) {
            dp[i][1] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            for (int kk = k; kk >= 1; kk--) {
                int tmp = dp[kk][1] ;
                dp[kk][1] = Math.max(dp[kk-1][0]-prices[i], dp[kk][1]);
                dp[kk][0] = Math.max(tmp+prices[i], dp[kk][0]);
                
            }
        }
        return dp[k][0];
    }

    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                max += prices[i] - prices[i - 1];
        }
        return max;
    }
}
// @lc code=end

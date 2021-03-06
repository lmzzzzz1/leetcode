/*
 * @lc app=leetcode.cn id=309 lang=java
 *
 * [309] 最佳买卖股票时机含冷冻期
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n==0) return 0;
        int[][]dp = new int[n+1][2];// 0:clear 1:hold 2:cold
        dp[1][0] = 0; dp[1][1] = -prices[0];
        for (int i = 2; i<=n; i++) {
            dp[i][0] =  Math.max(dp[i-1][0], dp[i-1][1]+prices[i-1]);
            dp[i][1] = Math.max(dp[i-2][0]-prices[i-1], dp[i-1][1]);
        }
        return dp[n][0];
    }

    int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=123 lang=java
 *
 * [123] 买卖股票的最佳时机 III
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int K = 2;
        int[][] mp_hold = new int[n][K+1];
        int[][] mp_clear = new int[n][K+1];
        

        for (int i = 0; i < n; i++) {
            for (int k = 1; k <= K; k++) {
                if(i == 0) {
                    mp_hold[0][0] = Integer.MIN_VALUE;
                    mp_hold[0][k] = -prices[0];
                    mp_clear[0][0] = 0;
                    mp_clear[0][k] = 0;
                    continue;
                }
                mp_hold[i][k] = Math.max(mp_hold[i-1][k], mp_clear[i-1][k-1]-prices[i]);
                mp_clear[i][k] = Math.max(mp_clear[i-1][k], mp_hold[i-1][k]+prices[i]);
            }
        }
        return mp_clear[n-1][K];

    }
}
// @lc code=end

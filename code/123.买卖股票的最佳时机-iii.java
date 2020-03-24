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
        int[] mp_hold_2 = new int[n];
        int[] mp_clear_2 = new int[n];
        int[] mp_hold_1 = new int[n];
        int[] mp_clear_1 = new int[n];
        mp_clear_1[0] = 0; mp_hold_1[0] = -prices[0];
        mp_clear_2[0] = 0; mp_hold_2[0] = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            mp_clear_1[i] = Math.max(mp_clear_1[i-1], mp_hold_1[i-1]+prices[i]);
            mp_clear_2[i] = Math.max(mp_clear_2[i-1], mp_hold_2[i-1]+prices[i]);
            mp_hold_1[i] = Math.max(mp_hold_1[i-1], -prices[i]);
            mp_hold_2[i] = Math.max(mp_hold_2[i-1], mp_clear_1[i-1]-prices[i]);
        }
        return Math.max(mp_clear_2[n-1], mp_clear_1[n-1]);
    }
}
// @lc code=end

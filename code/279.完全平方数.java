/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            dp[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            int j = 1;
            for (; j*j<i;j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
            if (j*j == i) dp[i] = 1;
        }
        return dp[n];
    }
}
// @lc code=end


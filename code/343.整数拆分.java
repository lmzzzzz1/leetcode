/*
 * @lc app=leetcode.cn id=343 lang=java
 *
 * [343] 整数拆分
 */

// @lc code=start
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j<i; j++) {
                int cur =  j * Math.max(dp[i-j], i-j);
                dp[i] = Math.max(dp[i], cur);
            }
        }
        return dp[n];
    }
}
// @lc code=end

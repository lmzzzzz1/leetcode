/*
 * @lc app=leetcode.cn id=376 lang=java
 *
 * [376] 摆动序列
 */

// @lc code=start
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return n;
        int[][] dp = new int[n][2];
        dp[0] = new int[] { 1, 1 }; // 0 for up, 1 for down
        for (int i = 1; i < n; i++) {
            if ((nums[i] - nums[i - 1]) > 0) {
                // up
                dp[i][0] = dp[i - 1][1] + 1;
                dp[i][1] = dp[i - 1][1];
            } else if ((nums[i] - nums[i - 1]) < 0) {
                dp[i][1] = dp[i - 1][0] + 1;
                dp[i][0] = dp[i - 1][0];
            } else {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1];
            }
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }
}
// @lc code=end

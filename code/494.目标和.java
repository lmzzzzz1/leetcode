/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int target = sum + S;
        if (target % 2 == 1)
            return 0;
        target /= 2;
        int dp[] = new int[target + 1];
        // dp[i][j] : 从nums[0~i] 选择一些数加起来等于j的最大组数
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            for (int j = target; j>=v ; j--) {
                dp[j] = dp[j] + dp[j-v];
            }
        }
        return dp[target];
    }
}
// @lc code=end

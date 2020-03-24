import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=377 lang=java
 *
 * [377] 组合总和 Ⅳ
 */

// @lc code=start
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        // dp[i]--> 组成i的最大组合个数
        dp[0] = 1;
        Arrays.sort(nums);
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < n && i >= nums[j]; j++) {
                dp[i] += dp[i-nums[j]];
            }
        }
        return dp[target];
    }
}
// @lc code=end

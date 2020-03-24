import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        // int[][] dp = new int[n][2];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if ((sum & 1) == 1) {
            return false;
        }
        sum >>= 1;
        // Arrays.sort(nums);
        // return dfs(nums, n-1, sum, sum);

        // 01背包法
        boolean[] dp = new boolean[sum+1];
        // dp[0] = true;
        // dp[i][j] 表示： 是否存在nums(0~i) 的子序列之和为j
        // if (sum >= nums[0]) {
        //     dp[0][nums[0]] = true;
        // }
        dp[0] = true;
        for (int i = 1; i < n; i++) {
            int weight = nums[i];
            for (int j = sum; j >= weight; j--) {
                if (dp[j - weight]) {
                    dp[j] = true;
                }
            }
        }
        return dp[sum];
    }

    // dfs+剪枝法
    boolean dfs(int[] nums, int n, int left, int right) {
        if (left == 0 || right == 0) {
            return true;
        }
        if (left < 0 || right < 0) {
            return false;
        }
        return dfs(nums, n - 1, left - nums[n], right) || dfs(nums, n - 1, left, right - nums[n]);
    }
}
// @lc code=end

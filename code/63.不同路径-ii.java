/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                }
                else if (i == m - 1 && j != n - 1) {
                    dp[i][j] = dp[i][j + 1];
                } else if (j == n - 1 && i != m - 1) {
                    dp[i][j] = dp[i + 1][j];
                } else if (i < m - 1 && j < n - 1) {
                    dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
                }

            }
        }
        return dp[0][0];
    }
}
// @lc code=end


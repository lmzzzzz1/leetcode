/*
 * @lc app=leetcode.cn id=474 lang=java
 *
 * [474] 一和零
 */

// @lc code=start
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (String s : strs) {
            int numOf0 = get0(s);
            int numOf1 = s.length() - numOf0;
            for (int i = m; i >= numOf0; i--) {
                for (int j = n; j >= numOf1; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1+dp[i-numOf0][j-numOf1]);
                }
            }
        }
        return dp[m][n];
    }

    private int get0(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (c == '0')
                sum++;
        }
        return sum;
    }
}
// @lc code=end

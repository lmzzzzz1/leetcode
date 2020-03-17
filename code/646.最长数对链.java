import java.util.Arrays;


/*
 * @lc app=leetcode.cn id=646 lang=java
 *
 * [646] 最长数对链
 */

// @lc code=start
class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, (a,b) -> (a[0]-b[0]));
        int max = 0;
        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j< i; j++) {
                if (pairs[i][0] > pairs[j][1]){
                    dp[i+1] = dp[j+1] + 1;
                }
            }
            max = Math.max(max, dp[i+1]);
        }
        return max;
    }
}
// @lc code=end


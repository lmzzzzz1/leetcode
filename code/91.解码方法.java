/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        if (s.length()==0) return 0;
        if (s.charAt(0) == '0') return 0;
        final int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 0; i<n; i++) {
            dp[i+1] = s.charAt(i)=='0'? 0:dp[i];
            if (i>0 && (s.charAt(i-1)=='1'||s.charAt(i-1)=='2'&&s.charAt(i)<='6')){
                dp[i+1] += dp[i-1];
            }
        }
        return dp[n];
    }
}
// @lc code=end


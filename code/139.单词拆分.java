/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        // dp表示用该字典能否拼出 s[0,i]
        dp[0] = true;
        for (int i = 0; i <= n; i++) {
            for (String word:wordDict) {
                int len = word.length();
                if (i>=len && s.substring(i-len, i).equals(word))
                    dp[i] = dp[i-len]||dp[i];
            }            
        }
        return dp[n];
    }
}
// @lc code=end


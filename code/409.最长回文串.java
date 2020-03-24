/*
 * @lc app=leetcode.cn id=409 lang=java
 *
 * [409] 最长回文串
 */

// @lc code=start
class Solution {
    public int longestPalindrome(String s) {
        int[] lengthForChar = new int[58];
        for (char c : s.toCharArray()) {
            lengthForChar[c-'A']++;
        }
        boolean haveOdd = false;
        int max = 0;
        for (int i : lengthForChar) {
            if ((i & 1) == 1) {
                max += i - 1;
                haveOdd = true;
            } else
                max += i;
        }
        return haveOdd ? max + 1 : max;
    }
}
// @lc code=end

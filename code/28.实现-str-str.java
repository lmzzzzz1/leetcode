/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        int n = needle.length();
        if (n==0) {
            return 0;
        }
        for (int i = 0; i <= haystack.length()-n; i++) {
            if (haystack.substring(i,i+n).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end


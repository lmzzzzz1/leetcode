/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0||(x!=0 && x%10==0))
            return false;
        int reverse = 0;
        while (x > reverse) {
            // int i = ;
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return x == reverse || reverse/10==x;
    }
}
// @lc code=end

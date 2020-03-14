/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int pre2 = 0, pre1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = Math.max(pre1, pre2+nums[i]);
            pre2 = pre1;
            pre1 = max;
        }
        return pre1;
    }
}
// @lc code=end

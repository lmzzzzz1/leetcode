/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return nums[0];
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }

    public int rob(int[] nums, int start, int end) {
        int pre2 = 0, pre1 = 0;
        for (int i = start; i <= end; i++) {
            int max = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1 = max;
        }
        return pre1;
    }
}
// @lc code=end

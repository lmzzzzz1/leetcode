/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if (n<=1) return;
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0) {
                nums[l++] = nums[i];
            }
        }
        while(l<n){
            nums[l++] = 0;
        }
    }
}
// @lc code=end


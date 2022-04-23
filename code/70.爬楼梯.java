/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        int dp[] = new int [n+1];
        int dp_0 =  1, dp_1 = 1;
        for(int i = 2;i<=n; i++){
            int tmp= dp_1;
            dp_1 = dp_0+dp_1;
            dp_0 = tmp;
        }
        return dp_1;
    }
}
// @lc code=end


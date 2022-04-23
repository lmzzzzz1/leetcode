/*
 * @lc app=leetcode.cn id=137 lang=java
 *
 * [137] 只出现一次的数字 II
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int bit = 1<<i;
            int cnt = 0;
            for (int j : nums) {
                if ((j&bit)!=0){
                    cnt++;
                }
            }
            if (cnt%3!=0){
                res|=bit;
            }
        }
        return res;
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=260 lang=java
 *
 * [260] 只出现一次的数字 III
 */

// @lc code=start
class Solution {
    public int[] singleNumber(int[] nums) {
        int a = 0, b = 0;
        int cnt = 0;
        for (int i : nums) {
            cnt ^= i;
        }
        // 得到最低位的1
        int bit = cnt&(-cnt);
        for (int i : nums) {
            if ((i&bit)==0){
                a ^= i; 
            }else b ^= i;
        }
        return new int[]{a,b};
    }
}
// @lc code=end


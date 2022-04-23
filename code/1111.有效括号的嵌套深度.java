/*
 * @lc app=leetcode.cn id=1111 lang=java
 *
 * [1111] 有效括号的嵌套深度
 */

// @lc code=start
class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int idx = 0;
        for(char c:seq.toCharArray()){
            ans[idx++] = c=='('? idx  & 1:(idx+1)&1;
        }
        return ans;
    }
}
// @lc code=end


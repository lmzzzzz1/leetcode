/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n <= 0)
            return "";
        if (n == 1)
            return strs[0];
        int index = 0, min = Integer.MAX_VALUE;
        StringBuffer ans = new StringBuffer("");
        for (String string : strs) {
            min = Math.min(min, string.length());
        }
        while (index<min){
            for (int i = 1; i<n; i++) {
                if (strs[i].charAt(index)!= strs[i-1].charAt(index))
                    return ans.toString();
            }
            ans.append(strs[0].charAt(index));
            index++;
        }
        return ans.toString();
    }

}
// @lc code=end

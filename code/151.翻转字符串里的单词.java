/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 翻转字符串里的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] ss = s.trim().split(" ");
        for (int i = ss.length-1; i >= 0; i--) {
            if(!ss[i].trim().equals("")){
                sb.append(ss[i]).append(" ");
            }
        }
        return sb.toString().trim();
    }   
}
// @lc code=end


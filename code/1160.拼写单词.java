/*
 * @lc app=leetcode.cn id=1160 lang=java
 *
 * [1160] 拼写单词
 */

// @lc code=start
class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] dic = new int[26];
        for (char c : chars.toCharArray()) {
            dic[c-'a']++;
        }
        int sum = 0;
        for (String s: words) {
            boolean in = true;
            int[] cur = dic.clone();
            for (char c: s.toCharArray()) {
                if (cur[c-'a']<=0) {
                    in = false;
                    break;
                }else {
                    cur[c-'a']--;
                }
            }
            sum += in? s.length():0;
        }
        return sum;
    }
}
// @lc code=end


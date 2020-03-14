import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 滑动窗口
        int l = 0, r = 0;
        int max = 0;
        Map<Character,Integer> lastIndex = new HashMap<>();
        while (l < s.length() && r < s.length()) {
            if(lastIndex.containsKey(s.charAt(r))){
                l = Math.max(lastIndex.get(s.charAt(r))+1, l);
            }
            lastIndex.put(s.charAt(r), r);
            max = Math.max(max,r-l+1);
            r++;
        }
        return max;
    }
}
// @lc code=end

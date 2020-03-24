/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        if (s.length()==0) return "";
        String ans = s.substring(0, 1);
        int max = 1;
        for (int i=0; i<s.length(); i++) {
            int l = i-1, r = i+1;
            int length = 1;
            while (l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)) {
                length+=2;
                l--;
                r++;
            }
            if(length>max) {
                max = length;
                ans = s.substring(l+1,r);
            }
            l = i-1; r = i;
            length = 0;
            while (l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)) {
                length+=2;
                l--;
                r++;
            }
            if(length>max) {
                max = length;
                ans = s.substring(l+1,r);
            }
        }
        return ans;
    }
}
// @lc code=end


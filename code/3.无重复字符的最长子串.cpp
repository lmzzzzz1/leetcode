/*
 * @lc app=leetcode.cn id=3 lang=cpp
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
#include <string>
#include <unordered_map>
using namespace std;
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if(s.length()<=1) return s.length();
        int res = 0;
        int l = 0, r = 0;
        unordered_map<char,int> lastIndex;
        while(r<s.length()){
            if(lastIndex.find(s[r]) != lastIndex.end()){
                l = max(lastIndex[s[r]] + 1,l);
            }
            lastIndex[s[r]] = r;
            res = max(res,r++-l+1);
        }
        return res ;
    }
};
// @lc code=end


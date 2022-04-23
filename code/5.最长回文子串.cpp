/*
 * @lc app=leetcode.cn id=5 lang=cpp
 *
 * [5] 最长回文子串
 */

// @lc code=start
#include <string>
#include <vector>
using namespace std;
class Solution {
public:
    string longestPalindrome(string s) {
        int max = 1, begin = 0;
        int len = s.length();
        if (len<2)
        {
            return s;
        }
        vector<vector<bool> > dp(len,vector<bool>(len,true));
        for (size_t j = 1; j < len; j++)
        {
            for (size_t i = 0; i < j; i++)
            {
                if (s[i]!=s[j])
                {
                    dp[i][j] = false;
                }else{
                    if (j-i+1>3)
                    {
                        dp[i][j] = dp[i+1][j-1];
                    }
                    
                }
                if(dp[i][j] && max < j-i+1){
                    max = j-i+1;
                    begin = i;
                }
            }
            
        }
        return s.substr(begin,max);
    }
};
// @lc code=end


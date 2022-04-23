/*
 * @lc app=leetcode.cn id=3 lang=c
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start


int lengthOfLongestSubstring(char * s){
    int dict[128];
    memset(dict, -1, sizeof(dict));
    int res = 0, l = 0, r = 0;
    while(r<strlen(s)){
        if(dict[s[r]]+1 > l){
            l = dict[s[r]]+1;
        }
        dict[s[r]] = r;
        if(res<r-l+1) res = r-l+1;
        ++r;
    }
    return res;
}
// @lc code=end


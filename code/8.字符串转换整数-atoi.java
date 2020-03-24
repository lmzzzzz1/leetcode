/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String str) {
        if (str.length() == 0)
            return 0;
        int index = 0;
        int ans = 0;
        boolean negetive = false;
        // first step, delete ' '
        while (index < str.length() && str.charAt(index) == ' ') index++;
        if (index == str.length()) return 0;
        // Second, find + or -
        if (str.charAt(index) == '-') negetive = true;
        if (str.charAt(index) == '+' || str.charAt(index) == '-') index++;
        // Third, 判断是否是整数字符，和溢出的判断
        while(index<str.length() && str.charAt(index)>='0' && str.charAt(index)<='9') {
            int pop = str.charAt(index) - '0';
            if (!negetive&&(ans > Integer.MAX_VALUE/10 || ans == Integer.MAX_VALUE/10 && pop > 7)) {
                return Integer.MAX_VALUE;
            }
            if (negetive && (ans > Integer.MAX_VALUE/10 || ans == Integer.MAX_VALUE/10 && pop > 8)){
                return Integer.MIN_VALUE;
            }
            ans = ans*10+pop;
            index++;
        }
        return negetive? -ans:ans;
    }
}
// @lc code=end

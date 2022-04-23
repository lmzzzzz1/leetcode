import java.util.Map;

/*
 * @lc app=leetcode.cn id=65 lang=java
 *
 * [65] 有效数字
 */

// @lc code=start
class Solution {
    public boolean isNumber(String s) {
        
        char[]array = s.trim().toCharArray();
        int n = array.length;
        if (n==0) return false;
        int i = 0;
        boolean hasE = false;
        boolean hasNum = false;
        boolean hasDot = false;
        while (i<n) {
            char c = array[i];
            if (c=='+' || c== '-') {
                if (i!=0 && array[i-1]!='e' && array[i-1]!='E') return false;
            }else if (c=='e'|| c=='E') {
                if (hasE||!hasNum) return false;
                hasE = true;
                hasNum = false;
            }else if (c=='.') {
                if (hasDot || hasE) return false;
                hasDot = true;
            }else if (c>='0' && c<='9') {
                hasNum = true;
            }else {
                return false;
            }
            i++;
        }
        return hasNum;
    }
}
// @lc code=end


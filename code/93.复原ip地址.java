import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原IP地址
 */

// @lc code=start
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtracking(s, res, "",0,0);
        return res;
    }

    private void backtracking(String s, List<String> res, String cur, int index, int numOfDot){
        if (numOfDot == 4 && index == s.length()) {
            res.add(cur.substring(0,cur.length()-1));
        }
        if (numOfDot==4 && index != s.length()) return;
        if (index == s.length() && numOfDot <4) return;

        for (int i =1; i<=3 && index+i<= s.length();i++) {
            String adds = s.substring(index, index+i);
            if (i>1 && adds.charAt(0)=='0' || Integer.parseInt(adds)>255) continue;
            backtracking(s, res, cur+adds+'.', index+i, numOfDot+1);
        }
    }
}
// @lc code=end

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    String[] map = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    LinkedHashMap
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.equals("")) return res;
        dfs(digits,0,"",res);
        return res;
    }

    private void dfs(String digits, int index,String cur  ,List<String> res){
        // end of recusion
        if (index == digits.length()) {
            res.add(cur);
            return;
        }
        for(char c: map[digits.charAt(index)-'2'].toCharArray()){
            String s = new String(new char[]{c});
            dfs(digits, index+1, cur+s, res);
        }
    }
}
// @lc code=end

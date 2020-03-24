import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        String ans = "";
        List<List<String>> database = new ArrayList<>();
        for (int j = 0; j<numRows; j++) {
            database.add(new ArrayList<>());
        }
        int i = 0, index = 0, upOrDown = -1;
        while (index < s.length()) {
            database.get(i).add(s.substring(index, index + 1));
            if (i == numRows - 1 || i == 0) {
                upOrDown = -upOrDown;
            }
            i += upOrDown;
            index++;
        }
        for (int k = 0; k < numRows; k++) {
            for (int m = 0; m<database.get(k).size(); m++){
                ans+=database.get(k).get(m);
            }
        }
        return ans;
    }
}
// @lc code=end

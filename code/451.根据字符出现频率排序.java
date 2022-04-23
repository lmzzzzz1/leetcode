import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=451 lang=java
 *
 * [451] 根据字符出现频率排序
 */

// @lc code=start
class Solution {
    public String frequencySort(String s) {
        if (s.length() <= 1)
            return s;
        Map<Character, Integer> freForChar = new HashMap<>();
        for (char c : s.toCharArray()) {
            freForChar.put(c, freForChar.getOrDefault(c, 0) + 1);
        }
        List<Character>[] buckets = new ArrayList[s.length() + 1];
        for (char c : freForChar.keySet()) {
            int fre = freForChar.get(c);
            if (buckets[fre] == null)
                buckets[fre] = new ArrayList<>();
            buckets[fre].add(c);
        }

        StringBuffer sb = new StringBuffer();
        for (int i = buckets.length-1; i > 0 ; i--) {
            if(buckets[i]==null) continue;
            for (char c : buckets[i]) {
                int len = i;
                while(len-->0){
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
// @lc code=end

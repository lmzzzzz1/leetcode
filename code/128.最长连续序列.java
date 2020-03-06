import java.util.Set;

/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> numSet = new HashSet<>();
        for (int i : nums) {
            numSet.add(i);
        }
        int max = 1, cnt = 0;
        for (int i : numSet) {
            if (!numSet.contains(i - 1)) {
                cnt = 1;
                int cur = i;
                while (numSet.contains(cur + 1)) {
                    cnt++;
                    cur++;
                }
                max = Math.max(max, cnt);
            }
        }
        return max;
    }
}
// @lc code=end

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1248 lang=java
 *
 * [1248] 统计「优美子数组」
 */

// @lc code=start
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> indexOfOdd = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                indexOfOdd.add(i);
            }
        }
        if (indexOfOdd.size() < k)
            return 0;
        int left = 0, right = k-1;
        int sum = 0;
        while (right < indexOfOdd.size()){
            int leftIndex = indexOfOdd.get(left);
            int rightIndex = indexOfOdd.get(right);
            int leftnums = left==0? leftIndex+1:leftIndex - indexOfOdd.get(left-1);
            int rightnums = right==indexOfOdd.size()-1? nums.length - rightIndex: indexOfOdd.get(right+1) - rightIndex;
            sum += leftnums *rightnums;
        }
        return sum;
    }
}
// @lc code=end

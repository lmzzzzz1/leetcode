import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长上升子序列
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        // dp
        int n = nums.length;
        if (n == 0)
            return 0;
        // int[] dp = new int[n];
        // Arrays.fill(dp, 1);
        // int max = 1;
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < i; j++) {
        //         if (nums[i] <= nums[j]){
        //             continue;
        //         }
        //         dp[i] = Math.max(dp[i], dp[j] + 1);
        //     }
        //     max = Math.max(max, dp[i]);
        // }

        // br二分法
        List<Integer> LIS = new LinkedList<>();
        LIS.add(nums[0]);
        for (int i = 1; i<n;i++) {
            if(nums[i]>LIS.get(LIS.size()-1))
                LIS.add(nums[i]);
            int index = search(LIS, nums[i]);
            LIS.set(index, nums[i]);
        }
        return LIS.size();

        // return max;
    }

    private int search(List<Integer> LIS, int k) {
        // find first index of num > k
        int n = LIS.size(), l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (LIS.get(mid) < k)
                l = mid + 1;
            else if (LIS.get(mid) > k) {
                r = mid;
            } else {
                return mid;
            }
        }
        return r;
    }
}
// @lc code=end

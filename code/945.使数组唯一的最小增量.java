import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=945 lang=java
 *
 * [945] 使数组唯一的最小增量
 */

// @lc code=start
class Solution {
    public int minIncrementForUnique(int[] A) {
        int n = A.length;
        if (n<=1) return 0;
        Arrays.sort(A);
        int ans = 0;
        for (int i=1; i<n;i++) {
            if (A[i-1]>=A[i]) {
                ans += A[i-1]-A[i]+1;
                A[i] = A[i-1]+1;
            }
        }
        return ans;
    }
}
// @lc code=end


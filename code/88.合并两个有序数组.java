/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int index = m + n - 1;
        while (i>=0||j>=0) {
            if (i<0) {
                nums1[index--] = nums2[j--];
            }else if (j<0) {
                nums1[index--] = nums1[i--];
            }else if (nums1[i]<nums2[j]) {
                nums1[index--] = nums2[j--];
            }else{
                nums1[index--] = nums1[i--];
            }
        }
    }
}
// @lc code=end

/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        if(nums.length<=1) return;
        int lt = 0, lg = nums.length, i = 0;
        while(i<lg){
            if(nums[i]==0){
                swap(nums, lt++, i++);
            }else if(nums[i] == 2){
                swap(nums, --lg, i);
            }else{
                i++;
            }
        }

    } 

    

    private void swap(int[] nums, int j, int i) {
        int t = nums[j];
        nums[j] = nums[i];
        nums[i] = t;
    }










    private void sort(int[] nums, int l, int h) {
        if (l>=h) return;
        int lb = l, i = l + 1, rb = h;
        int v = nums[l];
        while (i <= rb) {
            int com = nums[i] - v;
            if (com < 0) {
                swap(nums, i++, lb++);
            } else if (com > 0) {
                swap(nums, i, rb--);
            } else {
                i++;
            }
        }
        sort(nums, l, lb-1);
        sort(nums, rb+1, h);
    }
}
// @lc code=end

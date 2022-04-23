import java.beans.beancontext.BeanContext;

/*
 * @lc app=leetcode.cn id=912 lang=java
 *
 * [912] 排序数组
 */

// @lc code=start
class Solution {
    public int[] sortArray(int[] nums) {
        return heapSort(nums);
    }
    public int[] heapSort(int[] nums) {
        int len = nums.length;
        for (int i =(len-1) /2;i>=0;i--){
            sink(nums, i, len-1);
        }

        for (int i = len-1; i >0; ){
            swap(nums, 0, i);
            i--;
            sink(nums, 0, i);
        }
        return nums;
    }

    private void sink(int[] nums, int i, int n) {
        while (2*i<n){
            int k = 2*i;
            if (nums[k]<nums[k+1]){
                k++;
            }
            if (nums[i]<nums[k]){
                swap(nums, k, i);
            }else break;
            i = k;
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


}
// @lc code=end


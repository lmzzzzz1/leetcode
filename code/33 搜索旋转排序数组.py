'''
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别。

示例 1:

输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
示例 2:

输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1
'''
# 解法一：查找题，还要求时间复杂度低，那么首先想到二分查找，首先设定start和last,
# 然后开始循环 while start<=last， mid = start+(last-start)/2
class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        left = 0
        right = len(nums)-1
        while(left<=right):
            mid = int(left + (right-left)/2)
            if nums[mid]==target:
                return mid
            if nums[left]<=nums[mid]: # 如果左边是升序
                if nums[left]<= target and target<=nums[mid]:
                    right = mid
                else:
                    left = mid+1
            else:
                # 如果右边是升序
                if nums[mid]<= target and target<=nums[right]:
                    left = mid
                else:
                    right = mid-1
        return -1

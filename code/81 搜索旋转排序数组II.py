'''假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。

编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。

示例 1:

输入: nums = [2,5,6,0,0,1,2], target = 0
输出: true
示例 2:

输入: nums = [2,5,6,0,0,1,2], target = 3
输出: false
进阶:

这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
'''
# 解法一：二分查找
class Solution:
    def search(self, nums: List[int], target: int) -> bool:
#         因为有重复项，所以不能简单地说nums[left]<=nums[mid]就是升序的
#         分两种情况，如果是<，那么一定是升序，没毛病
#         如果是=，left+=1,重新循环
        n = len(nums)
        if n ==0:
            return False
        left = 0
        right = n-1
        while left<=right:
            mid = left+int((right-left)/2)
            if nums[mid]==target:
                return True
            if nums[left]<=nums[mid]:
                if nums[left]==nums[mid]:
                    left+=1
                else:
                    if nums[left]<= target and nums[mid]>=target:
                        right = mid
                    else:
                        left = mid+1
            else:
                if nums[mid]<= target and nums[right]>=target:
                    left = mid
                else:
                    right = mid-1
        return False
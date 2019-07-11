'''
Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.
Example 2:

Given nums = [0,0,1,1,1,2,2,3,3,4],

Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

It doesn't matter what values are set beyond the returned length.
'''
# 解法一：快慢双指针,空间复杂度为 O(1)
class Solution:
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
#       双指针
        if not nums:
            return 0
        index = 0
        for i in nums:
            if nums[index]!=i:
                index+=1
                nums[index]=i
        return index+1        
           
           
           
# 解法二： 憨憨写法，使用字典，实际上没有必要用字典存储，空间复杂度为 O(n)
    def removeDuplicates_by_myself(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        i = 0
        is_in = {}
        while i<len(nums):
            if nums[i] not in is_in:
                is_in[nums[i]] = True
                i+=1
            else:
                nums.pop(i)
        return len(nums)
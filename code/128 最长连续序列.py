"""
给定一个未排序的整数数组，找出最长连续序列的长度。

要求算法的时间复杂度为 O(n)。

示例:

输入: [100, 4, 200, 1, 3, 2]
输出: 4
解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。

"""

# 解法一： 使用集合set
class Solution(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        A = set(nums)

        def find_left_and_right(n):
            if n in A:
                A.remove(n)
                return find_left_and_right(n - 1) + find_left_and_right(n + 1) + 1
            else:
                return 0

        ans = 0
        for i in nums:
            ans = max(ans, find_left_and_right(i))
        return ans

    def longestConsecutive_by_official(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        longest = 0
        num_set = set(nums)

        for i in num_set:
            if i - 1 not in num_set:

                cur = i
                cur_longest = 1

                while cur + 1 in num_set:
                    cur_longest += 1
                    cur += 1
                longest = max(longest, cur_longest)
        return longest

# 解法二：使用hashmap
    def longestConsecutive_by_hashmap(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums_dict = dict()
        longest = 0
        for n in nums:
            if n not in nums_dict:
                left = nums_dict.get(n-1,0)
                right = nums_dict.get(n+1,0)
                current = left+right+1
                longest = max(longest,current)
                nums_dict[n] = current
                nums_dict[n-left] = current
                nums_dict[n+right] = current
        return longest

if __name__ == '__main__':
    s = Solution()
    test_list = [100, 4, 200, 1, 3, 2]
    print(s.longestConsecutive_by_hashmap(test_list))

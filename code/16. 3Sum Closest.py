"""
Given an array nums of n integers and an integer target, 
find three integers in nums such that the sum is closest to target.
Return the sum of the three integers. 
You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)."""

# 解法一：参照上一道题，用l，r两个指针降低时间复杂度


class Solution:
    def threeSumClosest(self, nums: [int], target: int) -> int:
        ans = 0
        distance = 9999
        # 设置l,r代表两个指针
        nums.sort()  # 从小到大排个序
        for i in range(len(nums)-2):  # 去掉最后两位
            # if nums[i]>0:break # 如果最小的数已经大于零了，后面也没必要找了
            if nums[i] == nums[i-1] and i > 0:
                continue  # 如果和前面的值一样，就跳过
            l, r = i+1, len(nums)-1
            while (l < r):
                if abs((nums[i]+nums[l]+nums[r])-target) < distance:
                    distance = abs((nums[i]+nums[l]+nums[r])-target)
                    ans = nums[i]+nums[l]+nums[r]
                if (nums[i]+nums[l]+nums[r]) < target:
                    l += 1
                elif nums[i]+nums[l]+nums[r] > target:
                    r -= 1
                else:
                    return target
        return ans


if __name__ == "__main__":
    s = Solution()
    test = [1, 1, 1, 0]
    target = -100
    print(s.threeSumClosest(test, target))

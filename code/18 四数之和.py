"""
给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？
找出所有满足条件且不重复的四元组。

注意：

答案中不可以包含重复的四元组。

示例：

给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]

"""

# 解法一，参考三数之和的解法，时间复杂度为O(n^3)
# 在观看完网上的代码后，优化一些，主要是加了一些break条件

class Solution:
    def fourSum(self, nums: [int], target: int) -> [[int]]:
        if len(nums) < 4:
            return []
        ans = []
        nums.sort()  # 先排个序
        for n, v in enumerate(nums[:-3]):
            if n > 0 and v == nums[n-1]:
                continue
            # 当数组最小值和都大于target 跳出   
            if v+nums[n+1]+nums[n+2]+nums[n+3] > target:
                break
            # 当数组最大值和都小于target,说明i这个数还是太小,遍历下一个
            if v+nums[len(nums)-1]+nums[len(nums)-2]+nums[len(nums)-3] < target:
                continue

            for i in range(n+1, len(nums)-2):
                if i>n+1 and nums[i] == nums[i-1]:
                    continue
                # 当数组最小值和都大于target 跳出   
                if v+nums[i]+nums[i+1]+nums[i+2] > target:
                    break
                # 当数组最大值和都小于target,说明i这个数还是太小,遍历下一个
                if v+nums[len(nums)-1]+nums[len(nums)-2]+nums[i] < target:
                    continue    
                l, r = i+1, len(nums)-1
                while (l < r):
                    if v+nums[i]+nums[l]+nums[r]==target:
                        ans.append([v,nums[i],nums[l],nums[r]])
                        while l<r and nums[l]==nums[l+1] :
                            l+=1
                        while l<r and nums[r]==nums[r-1]:
                            r-=1
                        l+=1
                        r-=1
                    elif v+nums[i]+nums[l]+nums[r]<target:
                        l+=1
                    else :
                        r-=1
                    
        return ans

if __name__ == "__main__":
    s=Solution()
    test = [1,-2,-5,-4,-3,3,3,5]
    print(s.fourSum(test,-11))
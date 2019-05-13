'''给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
'''
# 解法一：利用双指针降低复杂度，基本思路就是去比较 i+l+r和0的大小
class Solution:
    def threeSum(self, nums) -> [int]:
        ans = []
        # 设置l,r代表两个指针
        nums.sort() # 从小到大排个序
        for i in range(len(nums)-2): #去掉最后两位
            if nums[i]>0:break # 如果最小的数已经大于零了，后面也没必要找了
            if nums[i]==nums[i-1] and i>0: continue # 如果和前面的值一样，就跳过
            l,r = i+1,len(nums)-1
            while (l<r):
                if nums[i]+nums[l]+nums[r]<0:
                    l+=1
                    continue
                if nums[i]+nums[l]+nums[r]>0:
                    r-=1
                    continue
                if nums[i]+nums[l]+nums[r]==0:
                    ans.append([nums[i],nums[l],nums[r]])
                    while l<r and nums[l]==nums[l+1] :
                        l+=1
                    while l<r and nums[r]==nums[r-1]:
                        r-=1
                    l+=1
                    r-=1
                    continue
        return ans

# 解法二：利用python的set避免重复
    def threeSum2(self, nums) -> [int]:
            if len(nums)<3:
                return []
            res = set()
            
            nums.sort() # 从小到大排个序
            
            for n,v in enumerate(nums[:-2]):
                if n>0 and v==nums[n-1]:
                    continue
                if v >0:
                    break
                dic = {}
                for m in nums[n+1:]:
                    if m not in dic:
                        dic[-m-v]=1
                    else:
                        res.add((v,m,-m-v)) # 添加元祖进去

            return list(map(list,res))

if __name__ == "__main__":
    s=Solution()
    test = [0,0,0,0]
    print(s.threeSum2(test))
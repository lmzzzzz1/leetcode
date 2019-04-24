# 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
# 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
# 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
# 说明：你不能倾斜容器，且 n 的值至少为 2。


# 如题意，垂直的两条线段将会与坐标轴构成一个矩形区域，
# 较短线段的长度将会作为矩形区域的宽度，
# 两线间距将会作为矩形区域的长度，
# 而我们必须最大化该矩形区域的面积。

# 解法一，暴力法两次遍历,时间溢出，此方法时间复杂度为 O(n²)
'''class Solution:
    def maxArea(self, height) -> int:
        area = 0
        for i,ai in enumerate(height):
            for j,aj in enumerate(height[i+1:]):
                j = j+i+1
                area = max(area,(j-i)*min(aj,ai))

        return area'''


# 解法二，双指针法，核心思想就是，一般来说两线段距离越远，得到的面积就越大，而两线段之间形成的区域总是会受到其中较短那条长度的限制
# 所以我们从两端开始，往中间移动，每次固定最长的那个位置，然后往中间移动
# 此方法时间复杂度为 O(n)
class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        i, j, area = 0, len(height)-1, 0
        while(i < j):
            area = max(area, (j-i)*min(height[i],height[j]))
            if height[i]<=height[j]:
                # 说明：如果 height[0] < height[3] 
                # 那么(0, 1), (0, 2)对应的容器体积一定小于(0, 3)的，
                # 因为此时计算体积的时候高为 height(0)，容器的宽减少而高不增加，面积必然缩小
                i+=1
            else:
                j-=1
        return area

if __name__ == "__main__":
    s = Solution()
    height = [1, 8, 6, 2, 5, 4, 8, 3, 7]
    print('================================')
    print(s.maxArea(height))

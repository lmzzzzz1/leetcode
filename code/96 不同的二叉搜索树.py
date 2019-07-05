'''
给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

示例:

输入: 3
输出: 5
解释:
给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 1
'''
class Solution(object):
    def numTrees(self, n):
        """
        :type n: int
        :rtype: int
        """
        if (n == 0) :
            return 0
        dp =[0]*(n+1)
        dp[0] = 1
        for g in range(1,n+1):
            for i in range(1,g+1):
                left = i-1
                right = g-i
                dp[g]+=dp[left]*dp[right]
        return dp[n]
'''
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
'''
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def generateTrees(self, n: int):
        if n==0:
            return []
        def helper(low,high): # 返回根节点列表
            if low > high:
                return [None]
            else:
                res = []
                for mid in range(low,high+1):
                    left = helper(low,mid-1)
                    right = helper(mid+1,high)
                    for l in left:
                        for r in right:
                            root = TreeNode(mid)
                            root.left = l
                            root.right = r
                            res.append(root)
                return res
        return helper(1,n)
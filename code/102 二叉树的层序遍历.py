'''
给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]
'''
from collections import deque
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
#  二叉树的层序遍历，使用递归，用level表示当前所在的层，如果level大于len(ans)就给ans一个空列表
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        ans = []
        
        def helper(root,level):
            if root:
                if level>len(ans):
                    ans.append([])
                ans[level-1].append(root.val)
                helper(root.left,level+1)
                helper(root.right,level+1)
        helper(root,1)
        return ans
# 解法二： 使用 queue，按照先进先出的原则
# python 中的 Queue 因为它是为多线程之间安全交换而设计的，所以使用了锁，会导致性能不佳。
# 因此在 Python 中可以使用 deque 的 append() 和 popleft() 函数来快速实现队列的功能。
    def levelOrder_by_queue(self, root):
        """
        :type root: TreeNode 
        :rtype: List[List[int]]
        """
        if  not root:
            return []
        ans = []
        Q = deque([root,])
        level = 1
        while Q:
            ans.append([])
            for i in range(len(Q)):
                cur = Q.popleft()
                ans[level-1].append(cur.val)
                if cur.left:
                    Q.append(cur.left)
                if cur.right:
                    Q.append(cur.right)
            level+=1
        return ans
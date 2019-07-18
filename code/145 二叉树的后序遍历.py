'''给定一个二叉树，返回它的 后序 遍历。

示例:

输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [3,2,1]
'''


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def postorderTraversal(self, root):
        # 后序遍历按照左节点、右节点、根节点的顺序遍历
        # 使用迭代的方法,设定一个last记录右子树已经被访问过了
        ans = []
        stack = []
        last = None
        while root or stack != []:
            while root:
                stack.append(root)
                root = root.left
            current = stack[-1]
            if not current.right or current.right == last:
                ans.append(current.val)
                stack.pop()
                last = current
                root = None
            else:
                root = current.right
        return ans

    def postorderTraversal_reverse(self, root):
        # 前序遍历是根，左，右，那么按照根，右，左的方法输出，很简单反转一下就能得到
        ans = []
        stack = []
        while root or stack != []:
            if root:
                ans.append(root.val)
                stack.append(root)
                root = root.right
            else:
                current = stack.pop()
                root = current.left

        return ans[::-1]

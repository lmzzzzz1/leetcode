'''给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
'''

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
# 方法一：递归算法，中序遍历按照：左子树-->根节点-->右子树的顺序遍历
class Solution:
    def inorderTraversal(self, root):
        ans = []
        def digui(root):
            if root != None:
                digui(root.left)
                ans.append(root.val)
                digui(root.right)
        digui(root)
        return ans

#  方法二：迭代法，利用栈的概念，先进后出
    def inorderTraversal_by_iteration(self, root):
        ans = []
        stack = []
        while(root != None or stack!=[]):
            while(root != None):
                stack.append(root)
                root = root.left
            current = stack.pop()
            ans.append(current.val)
            root = current.right 
        return ans

#  方法三： morris 遍历，使用数据结构————线索二叉树 Threaded Binary Tree
#  核心思想：把左子树的最右节点的右节点连接当前点
    def inorderTraversal_by_morris(self,cur):

            ans = []
            while cur:
                if cur.left is None:
                    ans.append(cur.val)
                    cur = cur.right
                else:
                    last = cur.left
                    while(last.right and cur!=last.right):
                        last = last.right
                    if not last.right:
                        last.right = cur
                        cur = cur.left
                    else:
                        # 说明这是第二次来到了这个点
                        ans.append(cur.val)
                        cur = cur.right
            return ans

if __name__ == "__main__":
    s = Solution()
    a1 = TreeNode(1)
    a2 = TreeNode(2)
    a3 = TreeNode(3)
    a1.right = a2
    a2.left = a3
    print(s.inorderTraversal_by_morris(a1))
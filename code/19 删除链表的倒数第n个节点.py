# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

# 解法一：遍历两次，第一次检测出链表的长度，第二次遍历到l-n位，跳过l-n+1位
class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        dummy = ListNode(0) #设定一个哑节点
        
        node_list = []
        node = head
        while not node.next:
            node_list.append(node)
            node = node.next
        if len(node_list)>1:
            node_list[-n].next = node    
        return head

if __name__ == "__main__":
    pass

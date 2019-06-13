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
        dummy.next = head 
        length = 0
        node = dummy
        while  node.next:
            length+=1
            node = node.next
        length-=n
        node = dummy
        while length > 0:
           length-=1
           node = node.next
        node.next = node.next.next
            
        return dummy.next

if __name__ == "__main__":
    first = ListNode(1)
    second = ListNode(2)
    third = ListNode(3)
    forth = ListNode(4)
    fifth = ListNode(5)
    first.next =second
    second.next = third
    third.next = forth
    forth.next = fifth
    s= Solution()
    print(s.removeNthFromEnd(first,2).val)

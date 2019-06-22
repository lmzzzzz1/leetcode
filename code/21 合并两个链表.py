"""
Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
按照从小到大排序
"""
# 方法一：使用递归
# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        def search(l1,l2):
            if l1 and l2: # 如果他俩都有值
                if l1.val<=l2.val:
                    nextnode = ListNode(l1.val) 
                    l1 = l1.next
                else:
                    nextnode = ListNode(l2.val)
                    l2 = l2.next
                nextnode.next = search(l1,l2)
            elif l1 and not l2: # l1有值，l2没有值
                nextnode = l1
            elif l2 and not l1:
                nextnode = l2
            else:
                nextnode =None
            return nextnode


        return search(l1,l2)

    def mergeTwoLists_from_leetcode(self, l1: ListNode, l2: ListNode) -> ListNode:
        if l1 and l2: # 如果l1和l2都不为空
            if l1.val > l2.val: l1, l2 = l2, l1
            l1.next = self.mergeTwoLists(l1.next, l2)
        return l1 or l2 # 如果有一个为空 


if __name__ == "__main__":
    first_left = ListNode(1)
    second_left = ListNode(2)
    third_left = ListNode(4)

    first_right = ListNode(1)
    second_right = ListNode(3)
    third_right = ListNode(4)
    first_left.next =second_left
    second_left.next = third_left
    first_right.next =second_right
    second_right.next = third_right
    s= Solution()
    print(s.mergeTwoLists(first_left,first_right).val)
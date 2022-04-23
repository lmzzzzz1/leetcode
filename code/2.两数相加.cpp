/*
 * @lc app=leetcode.cn id=2 lang=cpp
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution
{
public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2)
    {
        if(l1==nullptr and l2==nullptr) return nullptr;
        if(l1==nullptr) return l2;
        if(l2==nullptr) return l1;

        int val = (l1->val + l2->val ) % 10;
        int plus = (l1->val + l2->val ) / 10;
        ListNode *p = new ListNode(val);
        p->next = addTwoNumbers(l1->next,l2->next);
        if(plus) p->next = addTwoNumbers(p->next,new ListNode(1));
        return p;
    }
};
// @lc code=end

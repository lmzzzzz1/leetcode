/*
 * @lc app=leetcode.cn id=2 lang=c
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2){
        if(l1==NULL && l2==NULL) return NULL;
        if(l1==NULL) return l2;
        if(l2==NULL) return l1;

        int val = (l1->val + l2->val ) % 10;
        int plus = (l1->val + l2->val ) / 10;
        struct ListNode *p = (struct ListNode*)malloc(sizeof(struct ListNode));
        memset(p, 0, sizeof(struct ListNode));
        p->val = val;
        p->next = addTwoNumbers(l1->next,l2->next);
        struct ListNode* one = (struct ListNode*)malloc(sizeof(struct ListNode));
        memset(one, 0, sizeof(struct ListNode));
        one->val = 1;
        if(plus) p->next = addTwoNumbers(p->next,one);
        return p;

}
// @lc code=end


/*
 * @lc app=leetcode.cn id=144 lang=cpp
 *
 * [144] 二叉树的前序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        if (!root)
            return {};
        vector<int> res = {root->val};
        vector<int> res_l = preorderTraversal(root->left);
        vector<int> res_r = preorderTraversal(root->right);
        res.insert(res.end(), res_l.begin(), res_l.end());
        res.insert(res.end(), res_r.begin(), res_r.end());
        return res;
    }
};
// @lc code=end


/*
 * @lc app=leetcode.cn id=543 lang=cpp
 *
 * [543] 二叉树的直径
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
    int diameter = 0;
    int diameterOfBinaryTree(TreeNode* root) {
        maxdepfromroot(root);
        return diameter;
    }
    int maxdepfromroot(TreeNode* root){
        if (root == nullptr)
            return 0;
        int leftlen = root->left ? maxdepfromroot(root->left) + 1 : 0;
        int rightlen = root->right ? maxdepfromroot(root->right) + 1 : 0;
        diameter = max(diameter, leftlen+rightlen);
        return max(leftlen,rightlen);
    }
};
// @lc code=end


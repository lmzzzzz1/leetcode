/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    boolean result = true;
    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return result;
    }

    private int maxDepth(TreeNode root){
        if (root == null) return 0;
        int l = maxDepth(root.left)+1;
        int r = maxDepth(root.right)+1;
        if (Math.abs(l-r)>1) result = false;
        return Math.max(l, r);
    }
}
// @lc code=end


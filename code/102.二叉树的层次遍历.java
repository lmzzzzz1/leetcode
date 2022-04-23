import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层次遍历
 */

// @lc code=start

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> levelOrder(TreeNode root) {
        res = new ArrayList<>();
        helper(root,1);
        return res;
    }
    void helper(TreeNode root, int level) {
        if (root == null) return;
        if (level>res.size()){
            res.add(new ArrayList<>());
        }
        res.get(level-1).add(root.val);
        helper(root.left, level+1);
        helper(root.right, level+1);
    }
}
// @lc code=end


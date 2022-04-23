import java.util.LinkedList;
import java.util.Queue;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
 */

// @lc code=start

// Definition for a binary tree node.

public class Codec {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if(root==null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean flag = false;
            StringBuffer sb1 = new StringBuffer();
            while(size>0){
                TreeNode cur = queue.poll();
                if (cur==null){
                    sb1.append("null,");
                }else {
                    flag = true;
                    sb1.append(cur.val).append(",");
                    queue.add(cur.left);
                    queue.add(cur.right);
                }
                size--;
            }
            if (flag){
                sb.append(sb1.toString());
            }
        }
        while(sb.length()>=5 && sb.substring(sb.length()-5,sb.length()).equals("null,")){
            sb.delete(sb.length()-5, sb.length());
        }
        return "["+sb.substring(0,sb.length()-1)+"]";
    }

    public void sort(int[] nums){
        if (nums.length<=1) return;
        for (int i = 0; i<nums.length-1; i++) {
            int min = Integer.MAX_VALUE;
            int index = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j]<min){
                    min = nums[j];
                    index = j;
                }
            }
            swap(index, i);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()<=2) return null;
        String[] ss= data.substring(1, data.length()-1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(ss[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; i < ss.length; i++) {
            TreeNode parent = queue.poll();
            if(!ss[i].equals("null")){
                TreeNode left = new TreeNode(Integer.parseInt(ss[i]));
                parent.left = left;
                queue.add(left);
            }
            if(i++ < ss.length &&!ss[i].equals("null")){
                TreeNode right = new TreeNode(Integer.parseInt(ss[i]));
                parent.right = right;
                queue.add(right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.right = t3;
        t3.left = new TreeNode(4);
        System.out.println(new Codec().serialize(t1));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end

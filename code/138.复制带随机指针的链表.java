import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 复制带随机指针的链表
 */

// @lc code=start

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


class Solution {
    public Node copyRandomList(Node head) { 
        if ( head==null) return null;
        
        for(Node cur = head; cur!=null;cur = cur.next.next ) {
            Node cp = new Node(cur.val);
            cp.next = cur.next;
            cur.next = cp;
        }
        for(Node cur = head, cp = null; cur!=null;cur = cur.next.next ) {
            if (cur.random!=null){
                cur.next.random = cur.random.next;
            }
        }
        Node res = head.next;
        for(Node cur = head; cur!=null && cur.next!=null;){
            Node temp = cur.next;
            cur.next = temp.next;
            cur = temp;
        }
        return res;
    }
}
// @lc code=end


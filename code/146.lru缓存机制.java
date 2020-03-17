import java.util.HashMap;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制
 */

// @lc code=start
class LRUCache {
    class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    LinkedList<Node> cache;
    HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedList<>();
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        int v = map.get(key).value;
        put(key, v);
        return v;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (map.containsKey(key)) {// 在缓存中
            cache.remove(map.get(key));
            cache.addFirst(node);
            map.put(key, node);
        } else { // 不在缓存中  
            if (cache.size() == capacity) {
                Node last = cache.removeLast();
                map.remove(last.key);

            }
            cache.addFirst(node);
            map.put(key, node);

        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
// @lc code=end

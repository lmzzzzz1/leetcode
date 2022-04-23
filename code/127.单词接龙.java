import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord) || beginWord.length() != endWord.length())
            return 0;
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        // Set<String> visited = new HashSet<>();
        queue.offer(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                for (int i = 0; i < cur.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char[] array = cur.toCharArray();
                        array[i] = c;
                        String tmp = new String(array);
                        if (set.contains(tmp)){
                            if (tmp.equals(endWord)) return level+1;
                            set.remove(tmp);
                            queue.offer(tmp);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }

}
// @lc code=end

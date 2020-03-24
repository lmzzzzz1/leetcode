import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=1091 lang=java
 *
 * [1091] 二进制矩阵中的最短路径
 */

// @lc code=start
class Solution {
    int[][] directions = new int[][]  {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int length = 0;
        Queue<int[]> queue = new LinkedList<>();
        if (grid[0][0] == 0)
            queue.offer(new int[] { 0, 0 });
        while (!queue.isEmpty()) {
            int size = queue.size();    
            length++;
            while (size-- > 0) {
                int[] cur = queue.poll();
                int i = cur[0], j = cur[1];
                if (i == grid.length - 1 && j == grid.length - 1) {
                    return length;
                }
                for (int[] d : directions) {
                    int i1 = i + d[0];
                    int j1 = j + d[1];
                    if (i1 >= grid.length || i1 < 0 || j1 >= grid.length || j1 < 0 || grid[i1][j1] == 1) {
                        continue;
                    }
                    queue.offer(new int[] { i1, j1 });
                    grid[i1][j1] = 1;
                }
            }
        }
        return -1;
    }
}
// @lc code=end

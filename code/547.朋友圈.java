import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 朋友圈
 */

// @lc code=start
class Solution {
    Set<Integer> isVisited = new HashSet<>();
    int []col = {-1,0,1,0};
    int []row = {0,-1,0,1};
    public int findCircleNum(int[][] M) {
        int n = M.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!isVisited.contains(i*n+j)&& M[i][j]==1) {
                    dfs(M, i, j);
                    ans++;
                }
            }
        }
        return ans;

    }

    void dfs(int[][] M, int i, int j) {
        if (!isValid(M, i, j)) return;
        if (isVisited.contains(i*M.length+j)) {
            return;
        }
        isVisited.add(i*M.length+j);
        for (int k = 0;k<4;k++) {
            dfs(M, i+col[k], j+row[k]);
        }
    }

    boolean isValid(int[][] M, int i, int j) {
        return i>=0 && j>=0 && i<M.length && j<M.length && M[i][j] == 1;
    }
}
// @lc code=end

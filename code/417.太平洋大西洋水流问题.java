import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 * @lc app=leetcode.cn id=417 lang=java
 *
 * [417] 太平洋大西洋水流问题
 */

// @lc code=start
class Solution {
    int[][]directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    int[][]matrix;

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix.length==0||matrix[0].length==0) return null;
        int m = matrix.length, n = matrix[0].length;
        boolean[][] canReachP = new boolean[m][n];
        boolean[][] canReachA = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(i,0,canReachP);
            dfs(i,n-1,canReachA);
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j, canReachP);
            dfs(m-1, j, canReachA);
        }
        List<List<Integer>> res= new ArrayList<>();
        for (int j = 0; j < m; j++) {
            for (int j2 = 0; j2 < n; j2++) {
                if (canReachA[j][j2] && canReachP[j][j2]){
                    res.add(Arrays.asList(j,j2));
                }
            }
        }
                
        return res;
    }

    void dfs(int i, int j, boolean[][]visited){
        if (visited[i][j]) return;
        visited[i][j] = true;
        for (int[] js : directions) {
            int m = i+js[0], n = j+js[1];
            if (m>=matrix.length||m<0||n>=matrix[0].length||n<0||matrix[m][n]<matrix[i][j]) continue;
            dfs(m,n,visited);
        }
        
    }

}
// @lc code=end


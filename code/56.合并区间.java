import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0]==b[0]? a[1]-b[1]: a[0]-b[0]));
        if (intervals.length <= 1)
            return intervals;
        List<int[]> res = new ArrayList<>();
        int left = intervals[0][0], right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0]>right){
                res.add(new int[]{left,right});
                left = intervals[i][0];
                right = intervals[i][1];
            }else {
                right = Math.max(right, intervals[i][1]); 
            }
        }
        res.add(new int[]{left,right});
        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }



    public String minNumber(int[] nums) {
        Integer[] s= sort(nums);
        StringBuffer sb = new StringBuffer(); 
        for (int i:s){
            sb.append(i);
        }
        return sb.toString();
    }

    private Integer[] sort(int[]nums){
        Integer[] s = new Integer[nums.length];
        int index =0;
        for (int i : nums) {
            s[index] = new Integer(i++);
        }
        Arrays.sort(s, (o1,o2)->( Integer.parseInt(o1+""+o2) -  Integer.parseInt(o2+""+o1)));;
        return s;
    }

}
// @lc code=end

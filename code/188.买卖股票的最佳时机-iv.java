/*
 * @lc app=leetcode.cn id=188 lang=java
 *
 * [188] 买卖股票的最佳时机 IV
 */

// @lc code=start
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0)
            return 0;
        if (k>prices.length/2) return maxProfit(prices);
        int[][][] mp = new int [prices.length][k+1][2];
        //base 
        
        for(int n = 0; n<prices.length;n++) {
            
            for(int kk = k; kk>=1;kk--){
                if(n==0){
                    mp[0][kk][1] = -prices[n];
                    mp[0][kk][0] = 0;
                    mp[0][0][1] = Integer.MIN_VALUE;
                    mp[0][0][0] = 0;
                    continue;
                }
                mp[n][kk][0] = Math.max(mp[n-1][kk][0], mp[n-1][kk][1]+prices[n]);
                mp[n][kk][1] = Math.max(mp[n-1][kk][1], mp[n-1][kk-1][0]-prices[n]);
            }
        }
        
        return mp[prices.length-1][k][0];
    }
    public int maxProfit(int[] prices){
        int max = 0;
        for(int i = 1; i<prices.length;i++) {
            if(prices[i]>prices[i-1]) max+=prices[i]-prices[i-1];
        }
        return max;
    }
}
// @lc code=end

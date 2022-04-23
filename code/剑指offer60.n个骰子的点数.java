class Solution {
    public double[] twoSum(int n) {
        // dp[n][s]是指 n个骰子掷出之和为s的种类个数
        int[][]dp = new int[n+1][6*n];
        // dp[n][s] = dp[n-1][s-1]+...+
        for (int i = 0; i < 6; i++) {
            dp[1][i+1] = 1;
        }
        for (int i = 2; i < dp.length; i++) {
            for (int j = i; j < dp.length; j++) {
                // dp[i][j] = 0;
                for (int k = 1; k<6 && j>=k;k++ ){
                    dp[i][j]+=dp[i-1][j-k];
                }
            }
        }
        int sum = 0;
        for (int p : dp[n]) {
            sum+=p;
        }
        double[] res = new double[5*n+1];
        for (int i = 0; i < res.length; i++) {
            res[i] = dp[n][i+n-1]*1.0/sum;
        }
        return res;
    }
}
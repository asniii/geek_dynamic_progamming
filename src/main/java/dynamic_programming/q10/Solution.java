package dynamic_programming.q10;

/***
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total
 * value in the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent
 * values and weights associated with n items respectively. Also given an integer W which represents knapsack
 * capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller
 * than or equal to W. You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 */
public class Solution {
    public static void main(String args[]) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;
        System.out.println(wrKnapSack(W, wt, val, n - 1));
        System.out.println(knapSack(W,wt,val,n));
    }

    public static int wrKnapSack(int W, int wt[], int val[], int n) {
        if (W <= 0) {
            return 0;
        }
        if (n < 0)
            return 0;
        return Math.max(val[n] + wrKnapSack(W - wt[n], wt, val, n - 1), wrKnapSack(W, wt, val, n - 1));
    }

    public static int knapSack(int W, int wt[], int val[], int n) {
        int dp[][] = new int[n + 1][W + 1];

        for (int i = 0; i <= W; i++) {
            dp[0][i] = 0;
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if(j >= wt[i-1])
                    dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]],dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][W];
    }
}

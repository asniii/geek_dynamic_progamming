package dynamic_programming.q9;

/***
 * Binomial Coefficient | DP-9
 * Following are common definition of Binomial Coefficients.
 *
 * A binomial coefficient C(n, k) can be defined as the coefficient of X^k in the expansion of (1 + X)^n.
 * A binomial coefficient C(n, k) also gives the number of ways, disregarding order, that k objects can be
 * chosen from among n objects; more formally, the number of k-element subsets (or k-combinations) of an n-element set.
 *
 *
 * C(n, k) = C(n-1, k-1) + C(n-1, k)
 * C(n, 0) = C(n, n) = 1
 */
public class Solution {
    public static void main(String args[]) {
        System.out.println("Binomial coefficient  is  :: " + wrBinomialCoefficient(5, 2));
        System.out.println("Binomial coefficient  is  :: " + binomialCoefficient(5, 2));
    }

    public static int wrBinomialCoefficient(int n, int k) {
        if (k == 0 || n == k)
            return 1;
        return wrBinomialCoefficient(n - 1, k - 1) + wrBinomialCoefficient(n - 1, k);
    }

    static int binomialCoefficient(int n, int k) {
        int dp[][] = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(k,i); j++) {
                if (j == 0 || i == j){
                    dp[i][j] = 1;
                }
                else {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }
        }
        return dp[n][k];
    }

}

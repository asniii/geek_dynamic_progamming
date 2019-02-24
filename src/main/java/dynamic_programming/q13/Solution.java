package dynamic_programming.q13;

/***
 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces. For example, if length of
 * the rod is 8 and the values of different pieces are given as following, then the maximum obtainable value is 22
 * (by cutting in two pieces of lengths 2 and 6).
 *
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 1   5   8   9  10  17  17  20
 *
 *
 */
public class Solution {
    public static void main(String args[]) {
        int arr[] = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is " +
                wrRodCutting(arr, arr.length));
        System.out.println("Maximum Obtainable Value is " +
                rodCutting(arr, arr.length));
    }

    static int wrRodCutting(int arr[], int size) {

        if (size < 1)
            return 0;

        int max_val = 0;

        for (int i = 1; i <= arr.length; i++) {
            if (size >= i) {
                int ans = arr[i - 1] + wrRodCutting(arr, size - i);
                if (ans > max_val) {
                    max_val = ans;
                }
            }
        }
        return max_val;
    }

    static int rodCutting(int arr[], int n) {
        int dp[][] = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
            dp[i][0] = 0;
        }

        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=n;j++){
                if(j>=i){
                    dp[i][j] = Math.max(arr[i-1] + dp[i][j-i],dp[i-1][j]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][n];

    }
}

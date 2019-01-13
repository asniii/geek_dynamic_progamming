package q6;

/***
 * Given a cost matrix cost[][] and a position (m, n) in cost[][],
 * write a function that returns cost of minimum cost path to reach (m, n) from (0, 0).
 * Each cell of the matrix represents a cost to traverse through that cell.
 * Total cost of a path to reach (m, n) is sum of all the costs on that path (including both source and destination).
 * You can only traverse down, right and diagonally lower cells from a given cell,
 * i.e., from a given cell (i, j), cells (i+1, j), (i, j+1) and (i+1, j+1) can be traversed.
 * You may assume that all costs are positive integers.
 */
public class Solution {
    public static void main(String args[]){
        int cost[][] = { {1, 2, 3}, {4, 8, 2}, {1, 5, 3} };
        System.out.println(wrMinCostPath(cost,2,2));
        System.out.println(minCostPath(cost,2,2));
    }

    private static int wrMinCostPath(int arr[][],int n,int m){
        if(n == 0 && m == 0){
            return arr[0][0];
        }
        if(n ==0){
            return wrMinCostPath(arr,0,m-1) + arr[0][m];
        }
        if(m == 0){
            return wrMinCostPath(arr,n-1,0) + arr[n][0];
        }
        return min(wrMinCostPath(arr,n-1,m-1),wrMinCostPath(arr,n-1,m),wrMinCostPath(arr,n,m-1)) + arr[n][m];
    }

    static int min(int a,int b,int c){
        return Math.min(a,Math.min(b,c));
    }

    static int minCostPath(int cost[][], int n, int m)
    {
        int i, j;

        int dp[][] = new int[n+1][m+1];

        dp[0][0] = cost[0][0];

        /* Initialize first column of total cost(dp) array */
        for (i = 1; i <= n; i++)
            dp[i][0] = dp[i-1][0] + cost[i][0];

        /* Initialize first row of dp array */
        for (j = 1; j <= m; j++)
            dp[0][j] = dp[0][j-1] + cost[0][j];

        /* Construct rest of the dp array */
        for (i = 1; i <= n; i++)
            for (j = 1; j <= m; j++)
                dp[i][j] = min(dp[i-1][j-1],
                        dp[i-1][j],
                        dp[i][j-1]) + cost[i][j];

        return dp[m][n];
    }
}

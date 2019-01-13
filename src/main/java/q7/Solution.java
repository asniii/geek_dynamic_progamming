package q7;

public class Solution {
    public static void main(String args[]){
        int arr[] = {1, 2, 3};
        int sum = 4;
        System.out.println(wrCoinChange(arr,sum,arr.length-1));
        System.out.println(coinChange(arr,sum));
    }

    private static int wrCoinChange(int arr[],int sum,int n){
        if(sum == 0)
            return 1;
        if(sum<0)
            return 0;
        if(n <0)
            return 0;

        return wrCoinChange(arr,sum-arr[n],n) + wrCoinChange(arr,sum,n-1);

    }

    private static int coinChange(int arr[],int sum){

        int dp[][] = new int[arr.length][sum+1];

        for(int i = 0;i<arr.length;i++){
            dp[i][0] = 1;
        }

        for(int i = 0;i<arr.length;i++){
            for(int j = 1;j<=sum;j++){
                int x = (i>0)?dp[i-1][j]:0;
                int y = (j-arr[i]>=0)?dp[i][j-arr[i]]:0;
                dp[i][j] = x+y;
            }
        }

        return dp[arr.length-1][sum];
    }
}

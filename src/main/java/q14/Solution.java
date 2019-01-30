package q14;

/***
 * Maximum Sum Increasing Subsequence | DP-14
 * Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence of the
 * given array such that the integers in the subsequence are sorted in increasing order.
 */
public class Solution {

    public static void main(String args[]){
        int arr[] = new int[]{1, 101, 2, 3, 100, 4, 5};
        int n = arr.length;
        System.out.println("Sum of maximum sum "+
                "increasing subsequence is "+
                maxSumIS(arr, n));
    }

    private static int maxSumIS(int arr[],int n){
        int dp[] = new int[n];

        for(int i = 0;i<n;i++){
            dp[i] = arr[i];
        }
        int max = 0;
        for(int i = 0;i<n;i++){

            for(int j = 0;j<i;j++){
                if(arr[i]>arr[j] && dp[i] < dp[j] + arr[i]){
                    dp[i] = dp[j] + arr[i];
                    if(dp[i] >max){
                        max = dp[i];
                    }
                }
            }
        }
        return max;
    }
}

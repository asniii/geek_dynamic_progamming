package dynamic_programming.q24;

/***
 * Minimum number of jumps to reach end
 * Given an array of integers where each element represents the max number of steps that can be made forward from
 * that element. Write a function to return the minimum number of jumps to reach the end of the array (starting
 * from the first element). If an element is 0, then cannot move through that element.
 *
 */
public class Solution {

    // Driver code
    public static void main(String args[])
    {
        int arr[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
        int n = arr.length;
        System.out.println("Minimum number of jumps to reach end is "
                + recMinJumps(arr, 0, n-1));

        System.out.println("Dp approach is : " + dpMinJumps(arr,n));
    }

    static int dpMinJumps(int arr[], int n){
        int dp[] = new int[n];

        for(int i = 0;i<n;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[n-1] = 0;
        for(int i = n-2;i>=0;i--){
            if(arr[i] == 0){
                dp[i] = Integer.MAX_VALUE;
            } else {
                int temp = Integer.MAX_VALUE;
                for(int j = i+1; j<= i + arr[i] && j<n && dp[j]!=Integer.MAX_VALUE;j++){
                    temp = dp[j] + 1;
                    if(dp[i] > temp){
                        dp[i] = temp;
                    }
                }
            }
        }

        return dp[0];
    }



    static int recMinJumps(int arr[], int start, int end){
        if(start == end){
            return 0;
        }

        if(start > end){
            return Integer.MAX_VALUE;
        }

        if(arr[start] == 0){
            return Integer.MAX_VALUE;
        }

        int min = Integer.MAX_VALUE;
        for(int i = 1;i<=arr[start];i++){
            int temp = Integer.MAX_VALUE;
            if(recMinJumps(arr,start+i,end) == Integer.MAX_VALUE){
                temp = Integer.MAX_VALUE;
            } else {
                temp = 1 + recMinJumps(arr,start+i,end);
            }
            if(temp < min){
                min = temp;
            }
        }
        return min;
    }

}

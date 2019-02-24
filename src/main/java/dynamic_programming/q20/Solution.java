package dynamic_programming.q20;

/***
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
 * A pair (c, d) can follow another pair (a, b) if b < c. Chain of pairs can be formed in this fashion.
 * Find the longest chain which can be formed from a given set of pairs.
 */
public class Solution {


    public static void main(String[] args)
    {
        Pair arr[] = new Pair[] {new Pair(5,24), new Pair(15, 25),
                new Pair (27, 40), new Pair(50, 60)};
        System.out.println("Length of maximum size chain is " +
                maxChainLength(arr, arr.length));
    }

    static int maxChainLength(Pair arr[], int n) {

        int dp[] = new int[n];

        for(int i = 0;i<n;i++){
            dp[i] = 1;
        }

        for(int i=0;i<n;i++){
            for(int j = 0;j<i;j++){
                if(arr[j].b < arr[i].a && dp[i] < dp[j]+1 ){
                    dp[i] = dp[j] +1;
                }
            }
        }

        int max = 0;

        for(int i = 0;i<n;i++){
            if(dp[i] > max){
                max = dp[i];
            }
        }

        return max;
    }
}

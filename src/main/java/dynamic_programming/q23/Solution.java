package dynamic_programming.q23;

/***
 * Program for Fibonacci numbers
 * The Fibonacci numbers are the numbers in the following integer sequence.
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..
 *
 * In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the recurrence relation
 *
 *     Fn = Fn-1 + Fn-2
 * with seed values
 *
 *    F0 = 0 and F1 = 1.
 */
public class Solution {

    public static void main(String args[]){
        System.out.println("fib of 9 : " + fib(9));
    }

    static int fib(int n){
        int dp[] = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}

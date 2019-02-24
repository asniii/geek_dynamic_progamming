package dynamic_programming.q5;

/***
 * Given two strings str1 and str2 and below operations that can performed on str1.
 * Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
 *
 * Insert
 * Remove
 * Replace
 *
 * All of the above operations are of equal cost.
 */
public class Solution {
    public static void main(String args[]) {
        String str1 ="sundaysundaysunday";
        String str2 = "saturdaysaturdaysaturday";
        System.out.println(wrEditDistance(str1,str2,str1.length()-1,str2.length()-1));
        System.out.println(editDistance(str1,str2,str1.length()-1,str2.length()-1));
    }

    //wr stands for without recursion
    private static int wrEditDistance(String str1, String str2, int n, int m) {
        if(n==0)
            return m;
        if(m==0)
            return n;
        if(str1.charAt(n) == str2.charAt(m))
            return wrEditDistance(str1,str2,n-1,m-1);
        return 1+ min(wrEditDistance(str1,str2,n-1,m),wrEditDistance(str1,str2,n,m-1),wrEditDistance(str1,str2,n-1,m-1));
    }

    private static int min(int a,int b,int c){
        return Math.min(a,Math.min(b,c));
    }

    private static int editDistance(String str1, String str2, int n, int m){
        int dp[][] = new int[n+1][m+1];

        for(int i = 0;i<=n;i++){
            dp[i][0] =i;
        }

        for(int j = 0;j<=m;j++){
            dp[0][j] = j;
        }

        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else
                    dp[i][j] = 1+ min(dp[i][j-1],dp[i-1][j],dp[i-1][j-1]);
            }
        }
        return dp[n][m];
    }
}

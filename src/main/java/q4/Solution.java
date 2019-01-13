package q4;

/***
 * Longest Common Subsequence
 */
public class Solution {
    public static void main(String args[]){
        String str1 = "AGGTABaldfjlajdas";
        String str2 = "GXTXAYBkahgkahkahgalkd";
        char chArr1[] = str1.toCharArray();
        char chArr2[] = str2.toCharArray();

        System.out.println(withoutDpLCS(chArr1,chArr2,chArr1.length,chArr2.length));
        System.out.println(longestCommonSubsequence(chArr1,chArr2,chArr1.length,chArr2.length));
    }

    private static int withoutDpLCS(char chArr1[],char chArr2[],int n,int m){
        if(n == 0 || m == 0)
            return 0;
        if(chArr1[n-1] == chArr2[m-1]){
            return withoutDpLCS(chArr1,chArr2,n-1,m-1)+1;
        }
        return max(withoutDpLCS(chArr1,chArr2,n-1,m),withoutDpLCS(chArr1,chArr2,n,m-1));
    }

    private static int max(int a,int b){
        return (a>b)?a:b;
    }

    private static int longestCommonSubsequence(char chArr1[],char chArr2[], int n,int m){
        int dp[][] = new int[n+1][m+1];

        for(int i = 0;i<=n;i++){
            for(int j = 0;j<=m;j++){
                if(i==0||j==0){
                    dp[i][j] = 0;
                }
                else if(chArr1[i-1] == chArr2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}

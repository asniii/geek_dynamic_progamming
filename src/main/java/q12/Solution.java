package q12;

/***
 * Longest Palindromic Subsequence
 */
public class Solution {
    public static void main(String[] args) {
        String seq = "GEEKSFORGEEKS";
        int n = seq.length();
        System.out.println("The length of the LPS is " + wrLPS(seq, 0, n - 1));
        System.out.println("The length of the LPS is " + LPS(seq, 0, n - 1));
    }

    static int wrLPS(String seq, int a, int b) {
        if (a == b)
            return 1;
        if (a > b)
            return 0;
        if (seq.charAt(a) == seq.charAt(b))
            return 2 + wrLPS(seq, a + 1, b - 1);
        return Math.max(wrLPS(seq, a + 1, b), wrLPS(seq, a, b - 1));
    }

    static int LPS(String seq, int a, int b) {
        int dp[][] = new int[seq.length()][seq.length()];

        for(int i = 0;i<seq.length();i++){
            dp[i][i] = 1;
        }

        for(int i = 0;i<seq.length() -1 ;i++){
            if(seq.charAt(i) == seq.charAt(i+1)){
                dp[i][i+1] = 2;
            }
            else {
                dp[i][i+1] = 1;
            }
        }

        for(int l = 3;l<=seq.length();l++){
            for(int i = 0;i<seq.length()-l+1;i++){
                int j = i+l-1;
                if(seq.charAt(i) == seq.charAt(j)){
                    dp[i][j] = 2 + dp[i+1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }

            }
        }

        return dp[a][b];
    }
}

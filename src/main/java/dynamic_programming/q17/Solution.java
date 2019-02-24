package dynamic_programming.q17;


/***
 * Palindrome Partitioning | DP-17
 * Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome.
 *
 * This problem is a variation of Matrix Chain Multiplication problem. If the string is palindrome, then we simply return 0.
 * Else, like the Matrix Chain Multiplication problem, we try making cuts at all possible places, recursively calculate the
 * cost for each cut and return the minimum value.
 *
 * Let the given string be str and minPalPartion() be the function that returns the fewest cuts needed for palindrome partitioning.
 * following is the optimal substructure property.
 *
 * // i is the starting index and j is the ending index. i must be passed as 0 and j as n-1
 * minPalPartion(str, i, j) = 0 if i == j. // When string is of length 1.
 * minPalPartion(str, i, j) = 0 if str[i..j] is palindrome.
 *
 * // If none of the above conditions is true, then minPalPartion(str, i, j) can be
 * // calculated recursively using the following formula.
 * minPalPartion(str, i, j) = Min { minPalPartion(str, i, k) + 1 +
 *                                  minPalPartion(str, k+1, j) }
 *                            where k varies from i to j-1
 */
public class Solution {

    public static void main(String args[])
    {
        String str = "ababbbabbababa";
        System.out.println("Min cuts needed for Palindrome Partitioning is "+ minPalPartion(str));
    }

    private static int minPalPartion(String str){
        int n = str.length();

        int c[][] = new int[n][n];
        boolean p[][] = new boolean[n][n];

        int i,j,k,l;

        for(i = 0;i<n;i++){
            p[i][i] = true;
            c[i][i] = 0;
        }

        for(l = 2;l<=n;l++){
            for(i = 0;i<n-l+1;i++){
                j = i+l-1;

                if(l == 2){
                    p[i][j] = (str.charAt(i) == str.charAt(j));
                }
                else {
                    p[i][j] = (str.charAt(i) == str.charAt(j)) && p[i + 1][j - 1];
                }

                if(p[i][j] == true){
                    c[i][j] = 0;
                }
                else {
                    c[i][j] = Integer.MAX_VALUE;
                    for(k = i;k<=j-1;k++){
                        c[i][j] = Integer.min(c[i][j],c[i][k] + c[k+1][j] + 1);
                    }
                }
            }
        }

        return c[0][n-1];
    }
}

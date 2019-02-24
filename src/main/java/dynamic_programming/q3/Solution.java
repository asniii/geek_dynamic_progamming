package dynamic_programming.q3;

/***
 * Longest Increasing Subsequence
 */
public class Solution {
    public static void main(String args[]) {
        int arr[] =  {10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println(longestIncreasingSubsequence(arr));


    }

    static private int longestIncreasingSubsequence(int arr[]) {
        int longest_here[] = new int[arr.length];
        for(int i = 0;i<arr.length;i++){
            longest_here[i] = 1;
        }
        int longest_max=0;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && longest_here[i] < longest_here[j]+ 1){
                    longest_here[i] = longest_here[j]+1;
                    if(longest_here[i]>longest_max){
                        longest_max = longest_here[i];
                    }

                }
            }
        }
        return longest_max;
    }
}

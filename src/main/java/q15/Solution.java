package q15;


/***
 * Longest Bitonic Subsequence | DP-15
 * Given an array arr[0 … n-1] containing n positive integers, a subsequence of arr[] is called Bitonic if it is first increasing,
 * then decreasing. Write a function that takes an array as argument and returns the length of the longest bitonic subsequence.
 *
 * A sequence, sorted in increasing order is considered Bitonic with the decreasing part as empty. Similarly, decreasing
 * order sequence is considered Bitonic with the increasing part as empty.
 */
public class Solution {

    public static void main(String args[]) {
        int arr[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        int n = arr.length;
        System.out.println("Length of LBS is " + lbs(arr, n));

    }

    private static int lbs(int arr[], int n) {

        int dp_increasing[] = new int[n];

        for (int i = 0; i < n; i++) {
            dp_increasing[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp_increasing[i] < dp_increasing[j] + 1 && arr[i] > arr[j]) {
                    dp_increasing[i] = dp_increasing[j] + 1;
                }
            }
        }

        int dp_decreasing[] = new int[n];

        for (int i = 0; i < n; i++) {
            dp_decreasing[i] = 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (dp_decreasing[i] < dp_decreasing[j] + 1 && arr[i] > arr[j]) {
                    dp_decreasing[i] = dp_decreasing[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < dp_increasing[i] + dp_decreasing[i]-1) {
                max = dp_increasing[i] + dp_decreasing[i]-1;
            }
        }
        return max;
    }
}

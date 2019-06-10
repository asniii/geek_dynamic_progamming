package sorting.codingProblem.q3;

/**
 * Count Inversions in an array | Set 1 (Using Merge Sort)
 * Inversion Count for an array indicates – how far (or close) the array is from being sorted. If array is already
 * sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum.
 * Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j
 */
public class Solution {

    public static void main(String args[]){
        int arr[]= {1,20,6,4,5};
        System.out.println(getInvCount(arr));
    }

    static int getInvCount(int[] arr){
        int ans = 0;

        for(int i = 0;i<arr.length-1;i++){
            for(int j = i+1;j<arr.length;j++){
                if(arr[i] > arr[j]){
                    ans++;
                }
            }
        }
        return ans;
    }
}

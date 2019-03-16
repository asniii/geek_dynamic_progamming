package greedy.standard_greedy_algorithm.q1;

/**
 * You are given n activities with their start and finish times. Select the maximum number of activities that can
 * be performed by a single person, assuming that a person can only work on a single activity at a time.
 */

public class Solution {

    // Prints a maximum set of activities that can be done by a single
    // person, one at a time.
    //  n   -->  Total number of activities
    //  s[] -->  An array that contains start time of all activities
    //  f[] -->  An array that contains finish time of all activities
    public static void printMaxActivities(int s[], int f[], int n)
    {
        int time_done = 0;

        for(int i = 0;i<s.length;i++){
            if(time_done<=s[i]){
                System.out.println(i);
                time_done = f[i];
            }
        }
    }

    // driver program to test above function
    public static void main(String[] args)
    {
        int s[] =  {1, 3, 0, 5, 8, 5};
        int f[] =  {2, 4, 6, 7, 9, 9};
        int n = s.length;

        printMaxActivities(s, f, n);
    }
}

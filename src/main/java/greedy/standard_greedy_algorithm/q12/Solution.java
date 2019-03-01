package greedy.standard_greedy_algorithm.q12;

/***
 * Minimum Swaps for Bracket Balancing
 * You are given a string of 2N characters consisting of N ‘[‘ brackets and N ‘]’ brackets. A string is considered
 * balanced if it can be represented in the for S2[S1] where S1 and S2 are balanced strings. We can make an unbalanced
 * string balanced by swapping adjacent characters. Calculate the minimum number of swaps necessary to make a string
 * balanced.
 *
 * Examples:
 *
 * Input  : []][][
 * Output : 2
 * First swap: Position 3 and 4
 * [][]][
 * Second swap: Position 5 and 6
 * [][][]
 *
 * Input  : [[][]]
 * Output : 0
 * String is already balanced.
 */
public class Solution {

    public static void main(String args[])
    {
        String s = "[]][][";
        System.out.println(swapCount(s.toCharArray()) );

        s = "[[][]]";
        System.out.println(swapCount(s.toCharArray()) );

    }

    static int swapCount(char[] str){
        int swapCount = 0;
        int stack = 0;
        int j = 0;


        for(int i = 0;i<str.length; i++){
            if(str[i] == ']'){
                if(stack == 0){
                    for( j = i+1;j<str.length;j++){
                        if(str[j] == '['){
                            break;
                        }
                    }
                    swapCount += j-i;
                    char ch = str[i];
                    str[i] = str[j];
                    str[j] = ch;
                    stack = 1;
                } else {
                    stack--;
                }
            }
            else {
                stack++;
            }
        }
        return swapCount;
    }
}

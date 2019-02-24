package backtrack.q1;

/**
 * Write a program to print all permutations of a given string
 */

public class Solution {

    public static void main(String ags[]){
        String str = "abcdefghijkl";
        print(str.toCharArray(),0,str.length()-1);

    }

    public static void print(char[] str, int a, int b){
        if(a == b){
            System.out.println(str);
        } else {
            for(int i = a;i<=b;i++){
                swap(str,a,i);
                print(str,a+1,b);
                swap(str,a,i);
            }
        }
    }

    public static void swap(char[] str, int a,int b){
        char temp = str[a];
        str[a] = str[b];
        str[b] = temp;
    }
}

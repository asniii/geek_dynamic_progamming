package greedy.standard_greedy_algorithm.q11;


import java.util.LinkedList;
import java.util.Queue;

/***
 * Policemen catch thieves
 * Given an array of size n that has the following specifications:
 *
 * Each element in the array contains either a policeman or a thief.
 * Each policeman can catch only one thief.
 * A policeman cannot catch a thief who is more than K units away from the policeman.
 * We need to find the maximum number of thieves that can be caught.
 */
public class Solution {

    public static void main(String args[]){
        int k, n;
        char arr1[] =new char[] { 'T', 'T', 'P', 'P',
                'T', 'P' };
        k = 2;
        n = arr1.length;
        System.out.println("Maximum thieves caught: "
                +policeThief(arr1, n, k));
    }



    public static int policeThief(char arr1[],int n,int k){
        Queue<Node> queue = new LinkedList<Node>();
        int score = 0;
        for(int i = 0;i<arr1.length;i++){
            if(queue.isEmpty()){
                ((LinkedList<Node>) queue).add(new Node(arr1[i],i));
            }

            else {
                if(arr1[i] == 'T'){
                    if( ((LinkedList<Node>) queue).getFirst().ch== 'P'){
                        while(!queue.isEmpty()){
                            Node node = ((LinkedList<Node>) queue).pollFirst();
                            if(i -node.pos<=k){
                                score=score+1;
                                break;
                            }
                        }

                    } else {
                        ((LinkedList<Node>) queue).add(new Node('T',i));
                    }
                } else{
                    if(((LinkedList<Node>) queue).getFirst().ch == 'T'){
                        while(!queue.isEmpty()){
                            Node node = ((LinkedList<Node>) queue).pollFirst();
                            if(i - node.pos <=k){
                                score = score+1;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return score;
    }
}

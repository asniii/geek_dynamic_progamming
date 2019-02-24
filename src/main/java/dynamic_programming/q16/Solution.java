package dynamic_programming.q16;

public class Solution {

    private static int INF = 99999;
    private static int V = 4;


    public static void main (String[] args)
    {
        /* Let us create the following weighted graph
           10
        (0)------->(3)
        |         /|\
      5 |          |
        |          | 1
        \|/         |
        (1)------->(2)
           3           */
        int graph[][] = { {0,   5,  INF, 10},
                {INF, 0,   3, INF},
                {INF, INF, 0,   1},
                {INF, INF, INF, 0}
        };

        floydWarshall(graph);
    }

    public static void floydWarshall(int arr[][]){

        int dis[][] = new int[4][4];

        //copy the matrix
        for (int i =0;i<V;i++){
            for(int j = 0;j<V;j++){
                dis[i][j] = arr[i][j];
            }
        }


        for(int k = 0;k<V;k++){
            for(int i = 0;i<V;i++){
                for(int j = 0;j<V;j++){
                    if(dis[i][j] >dis[i][k] + dis[k][j]){
                        dis[i][j] = dis[i][k] + dis[k][j];
                    }
                }
            }
        }


        for(int i = 0;i<V;i++){
            for(int j = 0;j<V;j++){
                System.out.print(dis[i][j] + "   ");
            }
            System.out.println();
        }

    }
}

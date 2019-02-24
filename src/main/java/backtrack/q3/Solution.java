package backtrack.q3;

public class Solution {

    final static int N = 4;

    /* A utility function to print solution matrix
       sol[N][N] */
    static void printSolution(int sol[][])
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(" " + sol[i][j] +
                        " ");
            System.out.println();
        }
    }

    /* A utility function to check if x,y is valid
        index for N*N maze */
    static boolean isSafe(int maze[][], int x, int y)
    {
        // if (x,y outside maze) return false
        return (x >= 0 && x < N && y >= 0 &&
                y < N && maze[x][y] == 1);
    }

    /* This function solves the Maze problem using
       Backtracking. It mainly uses solveMazeUtil()
       to solve the problem. It returns false if no
       path is possible, otherwise return true and
       prints the path in the form of 1s. Please note
       that there may be more than one solutions, this
       function prints one of the feasible solutions.*/
    static boolean solveMaze(int maze[][])
    {
        int sol[][] = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        if (solveMazeUtil(maze, 0, 0, sol) == false)
        {
            System.out.print("Solution doesn't exist");
            return false;
        }

        printSolution(sol);
        return true;
    }

    /* A recursive utility function to solve Maze
       problem */
    static boolean solveMazeUtil(int maze[][], int x, int y,
                          int sol[][])
    {

        if(x == N-1 && y == N-1){
            return true;
        }

        if(isSafe(maze,x+1,y)){
            int tempx = x+1;
            sol[tempx][y] = 1;
            if(solveMazeUtil(maze,tempx,y,sol))
                return true;
            sol[tempx][y] = 0;
        }

        if(isSafe(maze,x,y+1)){
            int tempy = y+1;
            sol[x][tempy] = 1;
            if(solveMazeUtil(maze,x,tempy,sol))
                return true;
            sol[x][tempy] = 0;
        }
        return false;
    }

    public static void main(String args[])
    {

        int maze[][] = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };
        solveMaze(maze);
    }
}

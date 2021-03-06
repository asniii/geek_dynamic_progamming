package dynamic_programming.q8;

/***
 * Matrix Chain Multiplication |
 * Given a sequence of matrices, find the most efficient way to multiply these matrices together.
 * The problem is not actually to perform the multiplications, but merely to decide in which order
 * to perform the multiplications.
 */
public class Solution {
    public static void main(String args[]) {
        int arr[] = new int[]{1, 2, 3, 4, 3};
        int n = arr.length;

        System.out.println("Minimum number of multiplications is " +
                wrMatrixChainOrder(arr, 1, n - 1));
        System.out.println("Minimum number of multiplications is " +
                matrixChainOrder(arr, arr.length));

    }

    public static int wrMatrixChainOrder(int arr[], int i, int j) {
        if (i == j) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = wrMatrixChainOrder(arr, i, k) + wrMatrixChainOrder(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
            if (temp < min)
                min = temp;
        }
        return min;
    }

    static int matrixChainOrder(int p[], int n)
    {
        /* For simplicity of the program, one extra row and one
        extra column are allocated in m[][].  0th row and 0th
        column of m[][] are not used */
        int m[][] = new int[n][n];

        int i, j, k, L, q;

        /* m[i,j] = Minimum number of scalar multiplications needed
        to compute the matrix A[i]A[i+1]...A[j] = A[i..j] where
        dimension of A[i] is p[i-1] x p[i] */

        // cost is zero when multiplying one matrix.
        for (i = 1; i < n; i++)
            m[i][i] = 0;

        // L is chain length.
        for (L=2; L<n; L++)
        {
            for (i=1; i<n-L+1; i++)
            {
                j = i+L-1;
                m[i][j] = Integer.MAX_VALUE;
                for (k=i; k<=j-1; k++)
                {
                    // q = cost/scalar multiplications
                    q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
                    if (q < m[i][j])
                        m[i][j] = q;
                }
            }
        }

        return m[1][n-1];
    }
}

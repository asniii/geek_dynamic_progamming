package greedy.standard_greedy_algorithm.q13;

/***
 * Fitting Shelves Problem
 * Given length of wall w and shelves of two lengths m and n, find the number of each type of shelf to be used and the
 * remaining empty space in the optimal solution so that the empty space is minimum. The larger of the two shelves is
 * cheaper so it is preferred. However cost is secondary and first priority is to minimize empty space on wall.
 *
 * Examples:
 *
 * Input : w = 24 m = 3 n = 5
 * Output : 3 3 0
 * We use three units of both shelves
 * and 0 space is left.
 * 3 * 3 + 3 * 5 = 24
 * So empty space  = 24 - 24 = 0
 * Another solution could have been 8 0 0
 * but since the larger shelf of length 5
 * is cheaper the former will be the answer.
 */

public class Solution {
    public static void main(String[] args)
    {
        int wall = 29, m = 3, n = 9;
        minSpacePreferLarge(wall, m, n);
    }

    private static void minSpacePreferLarge(int wall, int m ,int n){
        int m_best=0;
        int n_best=0;
        int waste=wall;

        int m_num=0;
        int n_num;

        for( n_num = wall/n;n_num>=0;n_num--){
            int temp_waste = wall - n_num*n - m_num*m;
            if(temp_waste == 0){
                m_best = m_num;
                n_best = n_num;
                waste = 0;
                break;
            }


            while(wall - n*n_num - m*(m_num ) >=0){
                temp_waste = wall -n*n_num - m_num*m;
                if(temp_waste ==0){
                    m_best = m_num;
                    n_best = n_num;
                    waste = 0;
                    break;
                }
                if(temp_waste<waste){
                    m_best = m_num;
                    n_best = n_num;
                    waste = temp_waste;
                }
                m_num++;
            }
        }

        System.out.println(m_best + "  " + n_best + "  " + waste);
    }
}

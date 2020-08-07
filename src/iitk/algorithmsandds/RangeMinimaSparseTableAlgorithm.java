package iitk.algorithmsandds;

public class RangeMinimaSparseTableAlgorithm {
// lookup[i][j] is going to store index
// of minimum value in arr[i..j].
// Ideally lookup table size should not be fixed
// and should be determined using n Log n.
// It is kept constant to keep code simple.
    static int MAX = 500;
    static int [][]lookup = new int[MAX][MAX];

    // Structure to represent a query range
    static class Query
    {
        int L, R;

        public Query(int L, int R)
        {
            this.L = L;
            this.R = R;
        }
    };

    public static void main(String[] args)
    {
        int a[] = {7, 2, 3, 0, 5, 10, 3, 12, 18};
        int n = a.length;
        Query q[] = {new Query(0, 4),
                new Query(4, 7),
                new Query(7, 8)};
        int m = q.length;
        RMQ(a, n, q, m);
    }

    // Fills lookup array lookup[][]
// in bottom up manner.
    static void preprocess(int arr[], int n)
    {
        // Initialize M for the intervals
        // with length 1
        for (int i = 0; i < n; i++)
            lookup[i][0] = i;

        // Compute values from smaller
        // to bigger intervals
        for (int j = 1; (1 << j) <= n; j++)
        {
            // Compute minimum value for
            // all intervals with size 2^j
            for (int i = 0; (i + (1 << j) - 1) < n; i++)
            {
                // For arr[2][10], we compare
                // arr[lookup[0][3]] and arr[lookup[3][3]]
                if (arr[lookup[i][j - 1]] <
                        arr[lookup[i + (1 << (j - 1))][j - 1]])
                    lookup[i][j] = lookup[i][j - 1];
                else
                    lookup[i][j] = lookup[i + (1 << (j - 1))][j - 1];
            }
        }
    }

    // Returns minimum of arr[L..R]
    static int query(int arr[], int L, int R)
    {
        // For [2,10], j = 3
        int j = (int)Math.log(R - L + 1);

        // For [2,10], we compare arr[lookup[0][3]]
        // and arr[lookup[3][3]],
        if (arr[lookup[L][j]] <=
                arr[lookup[R - (1 << j) + 1][j]])
            return arr[lookup[L][j]];

        else return arr[lookup[R - (1<<j) + 1][j]];
    }

    // Prints minimum of given m query ranges in arr[0..n-1]
    static void RMQ(int arr[], int n, Query q[], int m)
    {
        // Fills table lookup[n][Log n]
        preprocess(arr, n);

        // One by one compute sum of all queries
        for (int i = 0; i < m; i++)
        {
            // Left and right boundaries of current range
            int L = q[i].L, R = q[i].R;

            // Print sum of current query range
            System.out.println("Minimum of [" + L + ", " + R +
                    "] is " + query(arr, L, R));
        }
    }
}

/*

  Sparse table method (above) supports query time O(1) with extra space O(n Log n).

  The idea is to precompute minimum of all subarrays of size 2j where j varies from 0 to Log n.
  Like trivial method, we make a lookup table. Here lookup[i][j] contains minimum of range starting from i and of size 2j.
  For example lookup[0][3] contains minimum of range [0, 7] (starting with 0 and of size 23)

  https://www.geeksforgeeks.org/range-minimum-query-for-static-array/
 */
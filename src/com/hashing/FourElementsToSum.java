package com.hashing;

import java.util.HashMap;
class FourElementsToSum
{
    static class pair
    {
        int first, second;
        public pair(int first, int second)
        {
            this.first = first;
            this.second = second;
        }
    }

    // The function finds four elements
// with given sum X 
    static void findFourElements(int arr[],
                                 int n, int X)
    {
        // Store sums of all pairs in a hash table
        HashMap<Integer,
                pair> mp = new HashMap<Integer,
                pair>();
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                mp.put(arr[i] + arr[j],
                        new pair(i, j));

        // Traverse through all pairs and search
        // for X - (current pair sum).
        for (int i = 0; i < n - 1; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                int sum = arr[i] + arr[j];

                // If X - sum is present in hash table,
                if (mp.containsKey(X - sum))
                {

                    // Making sure that all elements are
                    // distinct array elements and an element
                    // is not considered more than once.
                    pair p = mp.get(X - sum);
                    if (p.first != i && p.first != j &&
                            p.second != i && p.second != j)
                    {
                        System.out.print(arr[i] + ", " + arr[j] +
                                ", " + arr[p.first] +
                                ", " + arr[p.second]);
                        return;
                    }
                }
            }
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        int arr[] = {10, 20, 30, 40, 1, 2};
        int n = arr.length;
        int X = 91;
        findFourElements(arr, n, X);
    }
}

//


/*
class FindFourElements
{

void findFourElements(int A[], int n, int X)
{
    // Fix the first element and find other three
    for (int i = 0; i < n - 3; i++)
    {
        // Fix the second element and find other two
        for (int j = i + 1; j < n - 2; j++)
        {
            // Fix the third element and find the fourth
            for (int k = j + 1; k < n - 1; k++)
            {
                // find the fourth
                for (int l = k + 1; l < n; l++)
                {
                    if (A[i] + A[j] + A[k] + A[l] == X)
                        System.out.print(A[i]+" "+A[j]+" "+A[k]
                                +" "+A[l]);
                }
            }
        }
    }
}
    public static void main(String[] args)
    {
        FindFourElements findfour = new FindFourElements();
        int A[] = {10, 20, 30, 40, 1, 2};
        int n = A.length;
        int X = 91;
        findfour.findFourElements(A, n, X);
    }
}
 */
package com.Google.hashCode;

import java.io.IOException;
import java.util.HashSet;

public class knapsack {

    // Driver program to test above function
    public static void main(String args[]) throws IOException {

        int piece[] = new int[]{25, 10, 4};
        int W = 30;

        System.out.println(minSlicesDP(piece,piece.length,W));
    }

    static int minCoins(int coins[], int m, int V)
    {
        // base case
        if (V == 0) return 0;

        // Initialize result
        int res = Integer.MAX_VALUE;
        int total = 0;

        // Try every coin that has smaller value than V
        for (int i=0; i<m; i++)
        {
            if (coins[i] <= V)
            {
                int sub_res = minCoins(coins, m, V-coins[i]);

                if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res){
                    total = total + coins[i];
                    res = sub_res + 1;
                }
            }
        }
        return total;
    }

    static int minSlicesDP(int slices[], int m, int V)
    {
        // table[i] will be storing
        // the minimum number of slices
        // required for i value. So
        // table[V] will have result
        int table[] = new int[V + 1];
        HashSet<Integer> list = new HashSet<>();
        // Base case (If given value V is 0)
        table[0] = 0;

        // Initialize all table values as Infinite
        for (int i = 1; i <= V; i++)
            table[i] = Integer.MAX_VALUE;


        int sum = 0;
        // Compute minimum slices required for all
        // values from 1 to V
        for (int i = 1; i <= V; i++)
        {
            // Go through all coins smaller than i
            for (int j = 0; j < m; j++)
                if (slices[j] <= i)
                {
                    int sub_res = table[i - slices[j]];
                    if (sub_res != Integer.MAX_VALUE
                            && sub_res + 1 < table[i]){
                        table[i] = sub_res + 1;
                        list.add(j);
                        sum = sum + slices[j];
                    }
                }

        }
        System.out.println(list.toString());
        System.out.println(sum);
        return table[V];

    }
}
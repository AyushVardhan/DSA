package com.Geeksforgeeks.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BooleanMatrixProblem {
    static int mat[][] = new int[1000][1000];
    static int ar[] = new int[1000];
    static int ac[] = new int[1000];

    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while(t-- > 0)
        {
            int r = 0, c = 0;
            String str[] = read.readLine().trim().split("\\s+");
            r = Integer.parseInt(str[0]);
            c = Integer.parseInt(str[1]); //input the number of rows and columns

            for(int i = 0; i < r; i++)
            {
                int k = 0;
                str = read.readLine().trim().split("\\s+");
                for(int j = 0; j < c; j++)
                    mat[i][j] = Integer.parseInt(str[k++]);
            }

            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                {
                    if(mat[i][j] == 1) //if a 1 is encountered in the matrix then
                    {                  //our temp arrays for row and columns are set to 1
                        ar[i] = 1;
                        ac[j] = 1;
                    }

                }
            }

            StringBuilder sb = new StringBuilder();
            for(int i =0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                {
                    if(ar[i] == 1 || ac[j] == 1)
                    {
                        mat[i][j] = 1;

                    }
                    sb.append(mat[i][j] + " ");
                }
                sb.append("\n");
            }
            System.out.print(sb);

            Arrays.fill(ar, 0);
            Arrays.fill(ac, 0);
        }
    }
}
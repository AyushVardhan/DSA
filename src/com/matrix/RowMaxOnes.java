package com.matrix;

import java.io.IOException;
import java.util.Scanner;

public class RowMaxOnes {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();

        while (tests-- > 0){
            int rows = in.nextInt();
            int cols = in.nextInt();

            int arr[][] = new int[rows][cols];

            for (int i=0; i<rows; i++){
                for (int j = 0; j < cols; j++){
                    arr[i][j] = in.nextInt();
                }
            }

            int j = cols-1;
            int i = 0,row = 0;
            while (i < rows && j>=0){
                if (arr[i][j]==1){
                    row = i;
                    j--;
                }else {
                    i++;
                }
            }
            System.out.println(row);
        }
    }
}

/*
Check whether the number is Triangular or not. A number is termed as triangular number if we can represent it in the form of triangular grid of points such that the points form an equilateral triangle and each row contains as many points as the row number, i.e., the first row has one point, second row has two points, third row has three points and so on. The starting triangular numbers are 1, 3 (1+2), 6 (1+2+3), 10 (1+2+3+4).

Input:
The first line of input contains an integer T denoting the number of test cases. The first line of each test case is N, N is the number to be checked if it is traingular or not.

Output:
If the number is Triangular then display 1 otherwise 0.

Constraints:

1<= T <= 100
1<= N <= 10000000

Example:

Input:
5
3
4
6
55
345

Output:
1
0
1
1
0
 */

package com.Geeksforgeeks.puzzles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TriangularNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            int num = Integer.parseInt(br.readLine());
            int flag = 0;

            for (int i = 1 ; i <= num ; i++){
                int nthTriangular = i*(i+1)/2;

                if(nthTriangular == num){
                    break;
                }

                if (nthTriangular > num){
                    flag = 1;
                    break;
                }
            }

            if(flag==1){
                System.out.println(0);
            }else {
                System.out.println(1);
            }
        }
    }
}

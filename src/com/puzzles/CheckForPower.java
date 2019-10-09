/*
Given two positive numbers x and y, check if y is a power of x or not.

Input:
First line contains an integer, the number of test cases 'T'. Each test case should contain two positive numbers x and y.


Output:
Print 1 if y is a power of x, else print 0.


Constraints:
1<=T<=30
1<=x<=103
1<=y<=108


Example:
Input:
2
2 8
1 3

Output:
1
0

Explanation: 8 is a power of 2, but 3 is not a power of 1.

 */

package com.puzzles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckForPower {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            String[] input = br.readLine().split(" ");
            long x = Long.parseLong(input[0]);
            long y = Long.parseLong(input[1]);

            if (x == 1 && y == 1) {
                System.out.println(1);
            } else if (x == 1 && y > 1) {
                System.out.println(0);
            } else {
                while (y != 0) {
                    if (y % x == 0) {
                        y = y / x;
                    }else {
                        break;
                    }
                }

                if(y==1){
                    System.out.println(y);
                }else
                    System.out.println(0);
            }
        }
    }
}

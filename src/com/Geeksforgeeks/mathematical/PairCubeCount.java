/*
Given N, count all ‘a’(>=1) and ‘b’(>=0) that satisfy the condition a3 + b3 = N.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains integer N.

Output:
For each testcase, in a new line, print count of all 'a' and 'b' that satisfy the above equation.

Constraints:
1 <= T <= 100
a>=1, b>=0
1 <= N <= 105

Example:
Input:
2
9
28

Output:
2
2
 */

package com.Geeksforgeeks.mathematical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PairCubeCount {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0){
            int N = Integer.parseInt(br.readLine());
            int count = 0;

            for (int a = 1 ; a <= Math.cbrt(N) ; a++){
                for (int b = 0 ; b <= Math.cbrt(N) ; b++){
                    if(Math.pow(a,3)+Math.pow(b,3)==N){
                        count =  count+2;
                    }
                }
            }

            System.out.println(count/2);
        }
    }
}

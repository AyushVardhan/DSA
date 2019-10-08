/*
You are given 2 numbers (N , M); the task is to find N√M (Nth root of M).

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains two space separated integers N and M.

Output:
For each test case, in a new line, print an integer denoting Nth root of M if the root is an integer else print -1.

Constraints:
1 <= T <= 200
2 <= N <= 20
1 <= M <= 109+5

Example:
Input:
2
2 9
3 9
Output:
3
-1
 */

package com.mathematical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NthRootOfM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            long M = Long.parseLong(input[1]);
            int flag = 0;

            for (int i = 1; i <= M; i++) {
                long pow = (long) Math.pow(i, N);
                if (pow < M) continue;
                else if (pow == M) {
                    System.out.println(i);
                    flag = 1;
                    break;
                }else if(pow > M){
                    break;
                }
            }

            if(flag==0){
                System.out.println(-1);
            }
        }
    }
}

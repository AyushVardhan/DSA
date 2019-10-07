/*
Find nCr for given n and r.

Input:
First line contains number of test cases T. T testcases follow. Each testcase contains 1 line of input containing 2 integers n and r separated by a space.

Output:
For each testcase, in a new line, find the nCr. Modulus your output to 109+7.

Constraints:
1 <= T <= 50
1<= n <= 103
1<= r <=800

Example:
Input:
2
3 2
4 2
Output:
3
6


 */

package com.mathematical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Combination {

    public static long MOD = (long) (Math.pow(10, 9) + 7);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int R = Integer.parseInt(input[1]);
            if(N >= R){
                long[][] dp = new long[N + 1][N + 1];
                long ans = 0; int flag = 0;

                //This loop will also give - Pascal Triangle
                for (int i = 0; i <= N; i++) {
                    for (int j = 0; j <= i; j++) {
                        if (j == 0) {
                            dp[i][j] = 1;
                        } else {
                            dp[i][j] = ((dp[i - 1][j-1])%MOD + (dp[i - 1][j])%MOD)%MOD;
                            if(i==N && j ==R){
                                ans = dp[i][j];
                                flag=1;
                                break;
                            }
                        }
                    }
                    if(flag==1){
                        break;
                    }
                }

                System.out.println(ans);
            }else{
                System.out.println(0);
            }
        }
    }
}
/*
You are given four numbers num1, den1, num2, and den2. You need to find (num1/den1)+(num2/den2) and output the result in the form of (numx/denx).

Input Format:
The first line of input contains an integer T denoting the number of test cases . Then T test cases follow . Each test case contains four integers num1, den1, num2, den2 respectively .

Output Format:
For each test case, in a new line,  output will be the fraction in the form a/b where the fraction denotes the sum of the two given fractions in reduced form.

Your Task:
Since this is a function problem, you don't need to worry about the testcases. Your task is to complete the function addFraction  which adds the two fractions and prints the resulting fraction. The function takes four arguments num1, den1, num2, den2 where num1, num2 denotes the numerators of two fractions and den1, den2 denotes their denominators.

Constraints:
1 <= T <= 100
1 <= den1,den2,num1,num2 <= 1000

Example:
Input
1
1 500 2 500
Output
3/500

Explanation:
In above test case 1/500+2/500=3/500
 */

package com.mathematical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddFractions {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            String[] input = br.readLine().split(" ");
            int num1 = Integer.parseInt(input[0]);
            int den1 = Integer.parseInt(input[1]);
            int num2 = Integer.parseInt(input[2]);
            int den2 = Integer.parseInt(input[3]);

            if(den1 == den2){
                System.out.println((num1+num2)+"/"+(den1));
            }else{
                long resd = (den1 * den2)/HCF(den1,den2);
                long resn = (num1*(resd/den1) + num2*(resd/den2));
                long K = HCF(resn,resd);
                resd = resd/K;
                resn = resn/K;
                System.out.println(resn+"/"+resd);
            }
        }
    }

    private static long HCF(long N, long M) {
        long a, b;
        if (N >= M) {
            a = N;
            b = M;
        } else {
            a = M;
            b = N;
        }

        long r;
        while (a > b) {
            r = a % b;
            if(r==0){
                break;
            }

            a = b;
            b = r;
        }
        return b;
    }
}

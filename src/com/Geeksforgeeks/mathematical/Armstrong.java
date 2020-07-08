/*
For a given 3 digit number, find whether it is armstrong number or not. An Armstrong number of three digits is an integer such that the sum of the cubes of its digits is equal to the number itself. For example, 371 is an Armstrong number since 33 + 73 + 13 = 371

Input:
First line contains an integer, the number of test cases 'T'. T testcases follow. Each test case contains a positive integer N.

Output:
For each testcase, in a new line, print "Yes" if it is a armstrong number else print "No".

Constraints:
1 <= T <= 31
100 <= N < 1000

Example:
Input:
1
371
Output:
Yes
 */

package com.Geeksforgeeks.mathematical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Armstrong {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0){
            int num = Integer.parseInt(br.readLine());
            int sum = 0, tmp = num;
            while (tmp > 0){
                sum += Math.pow(tmp%10,3);
                tmp /= 10;
            }
            if(sum == tmp){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
}

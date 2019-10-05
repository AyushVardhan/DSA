/*
Write a program to check if the sum of digits of a given number N is a palindrome number or not.

Input:
The first line of the input contains T denoting the number of testcases. T testcases follow. Then each of the T lines contains single positive integer N denoting the value of number.

Output:
For each testcase, in a new line, output "YES" if pallindrome else "NO". (without the quotes)

Constraints:
1 <= T <= 200
1 <= N <= 1000

Example:
Input:
2
56
98
Output:
YES
NO
 */

package com.mathematical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumIsPalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0){
            int num = Integer.parseInt(br.readLine());
            int tmp = num, sum = 0, rev = 0, rem = 0;
            while (tmp > 0){
                sum += tmp%10;
                tmp /= 10;
            }

            tmp = sum;

            while (sum > 0){
                rem = sum % 10;
                rev = rev*10 + rem;
                sum = sum / 10;
            }

            if(tmp == rev){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}

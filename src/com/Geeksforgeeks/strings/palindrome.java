/*
Given a string S, check if it is palindrome or not.

Input:
The first line contains 'T' denoting the number of test cases. T testcases follow. Each testcase contains two lines of input. The first line contains the length of the string and the second line contains the string S.

Output:
For each testcase, in a new line, print "Yes" if it is a palindrome else "No". (Without the double quotes)

Constraints:
1 <= T <= 30
1 <= N <= 100

Example:
Input:
1
4
abba
Output:
Yes

** For More Input/Output Examples Use 'Expected Output' option **
 */

package com.Geeksforgeeks.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class palindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            int size = Integer.parseInt(br.readLine());
            String input = br.readLine();
            String tmp = "";

            for (int i = size-1; i >= 0; i--) {
                tmp = tmp.concat(String.valueOf(input.charAt(i)));
            }

            if (tmp.equals(input)){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }
}

/*
Given a string S, write a program to title case every first letter of words in string.

Input:
The first line consists of an integer T i.e number of test cases. T testcases follow. The first and only line of each test case consists of a string S.

Output:
For each testcase, in a new line, print the required output.

Constraints:
1 <= T <= 100
1 <= |S| <= 1000

Example:
Input:
1
I love programming
Output:
I Love Programming

** For More Input/Output Examples Use 'Expected Output' option **
 */

package com.Geeksforgeeks.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UpperCaseConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            String s = br.readLine();
            char a[] = s.toCharArray();
            for (int i = 0; i < a.length; i++) {
                if (i==0 || (i!=0 && a[i-1]==' '))
                    a[i] = Character.toUpperCase(a[i]);
            }
            System.out.println(a);
        }
    }
}

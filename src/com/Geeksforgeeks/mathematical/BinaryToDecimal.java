/*
Given a Binary Number B, Print its decimal equivalent.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follow. Each test case contains a single Binary number B.

Output:
For each testcase, in a new line, print each Decimal number in new line.

Constraints:
1 <= T <= 100
1 <= Digits in Binary <= 16

Example:
Input:
2
10001000
101100
Output:
136
44
 */
package com.Geeksforgeeks.mathematical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryToDecimal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            String input = br.readLine();
            long decimal = 0;
            for (int i = input.length() - 1, j = 0; i >= 0; i--,j++) {
                decimal += Character.getNumericValue(input.charAt(i))*Math.pow(2,j);
            }
            System.out.println(decimal);
        }
    }
}

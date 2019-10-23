/*
Given a string S containing only lower case alphabets, the task is to sort it in lexigraphically-descending order.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains a string S.

Output:
For each test case, in a new line, print the sorted string.

Constraints:
1 <= T <= 100
1 <= |S| <= 105

Example:
Input:
2
geeks
for
Output:
skgee
rof
 */

package com.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SortTheString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-->0){
            String input = br.readLine();
            char[] charArr = input.toCharArray();
            Arrays.sort(charArr);
            for (int i = charArr.length-1; i >=0; i--){
                System.out.print(charArr[i]);
            }

            System.out.println();
        }
    }
}

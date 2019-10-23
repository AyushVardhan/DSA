/*
Given two strings S1 and S2 as input, the task is to merge them alternatively i.e. the first character of S1 then the first character of S2 and so on till the strings end.

NOTE: Add the whole string if other string is empty.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains two strings S1 and S2.

Output:
For each test case, in a new line, print the merged string.

Constraints:
1 <= T <= 100
1 <= |S1|, |S2| <= 104

Example:
Input:
2
Hello Bye
abc def

Output:
HBeylelo
adbecf
 */

package com.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeTwoString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            String[] input = br.readLine().split(" ");
            char str1[] = input[0].toCharArray();
            char str2[] = input[1].toCharArray();
            StringBuffer sbr = new StringBuffer();

            int i = 0, j = 0, k = 0;
            while (i < str1.length || j < str2.length) {
                if (k % 2 == 0 && i < str1.length) {
                    sbr.append(str1[i++]);
                }

                if (k % 2 != 0 && j < str2.length) {
                    sbr.append(str2[j++]);
                }

                k++;
            }

            System.out.println(sbr);
        }
    }
}

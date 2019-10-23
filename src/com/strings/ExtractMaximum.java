/*
You have been given an alphanumeric string S, extract maximum numeric value from that string. Alphabets will only be in lower case.

Input:
The first line contains a single integer T i.e. the number of test cases. T testcases follow. The first and only line consists of a String S.

Output:
For each testcase, in a new line, print the Maximum number extracted from the string S.

Constraints:
1 <= T <= 100
2 <= |S| <= 200

Example:
Input:
3
100klh564abc365bg
abvhd9sdnkjdfs
abchsd0sdhs
Output:
564
9
0

Explanation:
Test Case 1: The maximum number found in the string is "564".
 */

package com.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExtractMaximum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            char[] inp = br.readLine().trim().toCharArray();
            int tmp = 0, max = -1;
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < inp.length; i++) {
                if (inp[i] >= '0' && inp[i] <= '9') {
                    tmp = tmp * 10 + Character.getNumericValue(inp[i]);

                    if (i == inp.length - 1) {
                        list.add(tmp);
                        tmp = 0;
                    }
                } else {
                    list.add(tmp);
                    tmp = 0;
                }
            }

            for (Integer ent : list) {
                if (ent > max) {
                    max = ent;
                }
            }

            System.out.println(max);
        }
    }
}

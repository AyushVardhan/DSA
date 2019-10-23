/*
Given two strings A and B, find if A is a subsequence of B.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains two space separated strings A and B.

Output:
For each test case, in a new line, print 1 if a is sub-sequences of b else print 0.

Constraints:
1 <= T <= 900
1<= |A|,|B| <=104

Example:
Input:
2
AXY YADXCP
gksrek geeksforgeeks

Output:
0
1

Explanation:
Testcase1:
Input: A = "axy", B = "yadxcp"
Output: 0 (A is not a subsequence of B)
Testcase2:
Input: A = "gksrek", B = "geeksforgeeks"
Output: 1 (str1 is a subsequence of str2)
 */

package com.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            String[] inp = br.readLine().trim().split(" ");
            String str1 = inp[0];
            String str2 = inp[1];

            if (str2.length() < str1.length()) {
                System.out.println(0);
            } else {
                int count = 0;
                for (int i = 0, j = 0; i < str1.length(); i++){
                    char tmp = str1.charAt(i);
                    for (;j<str2.length(); j++){
                        if (tmp==str2.charAt(j)){
                            count++;
                            j++;
                            break;
                        }
                    }
                }

                if (count==str1.length()){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }
        }
    }
}

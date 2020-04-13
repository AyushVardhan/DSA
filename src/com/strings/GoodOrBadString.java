/*
In this problem, a String S is composed of lowercase alphabets and wildcard characters i.e. '?'. Here, '?' can be replaced by any of the lowercase alphabets. Now you have to classify the given String on the basis of following rules:

If there are more than 3 consonants together or more than 5 vowels together, the String is considered to be "BAD". A String is considered "GOOD" only if it is not “BAD”.

NOTE: String is considered as "BAD" if the above condition is satisfied even once. Else it is "GOOD" and the task is to make the string "BAD".

Input:
The first line consists of an integer T i.e number of test cases. T testcases follow. The first and only line of each test case consists of a string S.

Output:
For each testcase, in a new line, print "1"  if string is GOOD, else print "0".

Constraints:
1 <= T <= 100
1 <= |S| <= 100

Example:
Input:
2
aeioup??
bcdaeiou??
Output:
1
0
 */

package com.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoodOrBadString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            String inp = br.readLine();
            System.out.println(isGood(inp) ? 1 : 0);
        }
    }

    private static boolean isGood(String inp) {
        int cons = 0, vowel = 0;
        for (int i = 0; i < inp.length(); i++) {
            if (inp.charAt(i) == 'a' || inp.charAt(i) == 'e' || inp.charAt(i) == 'i' || inp.charAt(i) == 'o' || inp.charAt(i) == 'u') {
                vowel++;
                cons = 0;
            } else if (inp.charAt(i) == '?') {
                vowel++;
                cons++;
            } else {
                cons++;
                vowel =0;
            }

            if (vowel > 5 || cons > 3) {
                return false;
            }
        }
        return true;
    }
}

/*
Jarvis is weak in computing palindromes for Alphanumeric characters.
While Ironman is busy fighting Thanos, he needs to activate sonic punch but Jarvis is stuck in computing palindromes.
You are given a string S containing alphanumeric characters. Find out whether the string is a palindrome or not.
If you are unable to solve it then it may result in the death of Iron Man.

Input:
The first line of the input contains T, the number of test cases. T testcases follow.  Each line of the test case contains string 'S'.

Output:
Each new line of the output contains "YES" if the string is palindrome and "NO" if the string is not a palindrome.

Constraints:
1<=T<=100
1<=|S|<=100000
Note: Consider alphabets and numbers only for palindrome check. Ignore symbols and whitespaces.

Example:
Input:
2
I am :IronnorI Ma, i
Ab?/Ba

Output:
YES
YES
 */

package com.Geeksforgeeks.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SaveIronMan {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            char inp[] = br.readLine().toLowerCase().toCharArray();
            StringBuilder sbr = new StringBuilder();
            for (char chr : inp) {
                if ((chr >= 'a' && chr <= 'z') || (chr >= 48 && chr <= 57)) {
                    sbr.append(chr);
                }
            }

            String org = sbr.toString();
            String rev = sbr.reverse().toString();
            if (org.equals(rev)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

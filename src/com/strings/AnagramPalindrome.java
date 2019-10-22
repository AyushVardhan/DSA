/*
Given a string S, Check if characters of the given string can be rearranged to form a palindrome.
For example characters of “geeksogeeks” can be rearranged to form a palindrome “geeksoskeeg”, but characters of “geeksforgeeks” cannot be rearranged to form a palindrome.

Input:
First line consists of integer T  denoting the number of test cases. T testcases follow. For each testcase there are one line of input containing string S.

Output:
For each testcase, in a new line, print "Yes" if is possible to make it a palindrome, else "No".

Constraints:
1 <= T <= 100
1 <= |S| <= 1000

Example:
Input:
2
geeksogeeks
geeksforgeeks
Output:
Yes
No

** For More Input/Output Examples Use 'Expected Output' option **
 */

package com.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class AnagramPalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            String first = br.readLine();

            HashMap<String, Integer> map = new HashMap<>();

            for (int i = 0; i < first.length(); i++) {
                if (!map.containsKey(String.valueOf(first.charAt(i)))) {
                    map.put(String.valueOf(first.charAt(i)), 1);
                } else {
                    map.put(String.valueOf(first.charAt(i)), map.get(String.valueOf(first.charAt(i))) + 1);
                }
            }

            int flag = 0;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() % 2 != 0) {
                    flag++;
                }
            }

            if (flag > 1) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}

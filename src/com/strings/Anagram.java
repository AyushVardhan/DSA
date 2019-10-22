/*
Given two strings a and b consisting of lowercase characters. The task is to check whether two given strings are anagram of each other or not. An anagram of a string is another string that contains same characters, only the order of characters can be different. For example, “act” and “tac” are anagram of each other.

Input:
The first line of input contains an integer T denoting the number of test cases. Each test case consist of two strings in 'lowercase' only, in a single line.

Output:
Print "YES" without quotes if the two strings are anagram else print "NO".

Constraints:
1 ≤ T ≤ 300
1 ≤ |s| ≤ 1016

Example:
Input:
2
geeksforgeeks forgeeksgeeks
allergy allergic

Output:
YES
NO

Explanation:
Testcase 1: Both the string have same characters with same frequency. So, both are anagrams.
Testcase 2: Characters in both the strings are not same, so they are not anagrams.
 */

package com.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            String[] input = br.readLine().split(" ");
            String first = input[0];
            String second = input[1];

            HashMap<String, Integer> map = new HashMap<>();

            for (int i = 0; i < first.length(); i++) {
                if (!map.containsKey(String.valueOf(first.charAt(i)))) {
                    map.put(String.valueOf(first.charAt(i)), 1);
                } else {
                    map.put(String.valueOf(first.charAt(i)), map.get(String.valueOf(first.charAt(i))) + 1);
                }
            }

            for (int i = 0; i < second.length(); i++) {
                if (!map.containsKey(String.valueOf(second.charAt(i)))) {
                    map.put(String.valueOf(second.charAt(i)), 1);
                } else {
                    map.put(String.valueOf(second.charAt(i)), map.get(String.valueOf(second.charAt(i))) + 1);
                }
            }

            int flag = 0;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() % 2 != 0) {
                    flag = 1;
                    break;
                }
            }

            if (flag == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

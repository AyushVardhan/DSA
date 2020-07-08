/*
Your task is to implement the function strstr. The function takes two strings as arguments (s,x) and  locates the occurrence of the string x in the string s. The function returns and integer denoting the first occurrence of the string x in s.

Input Format:
The first line of input contains an integer T denoting the no of test cases . Then T test cases follow. The first line of each test case contains two strings s and x.

Output Format:
For each test case, in a new line, output will be an integer denoting the first occurrence of the x in the string s. Return -1 if no match found.

Your Task:
Since this is a function problem, you don't have to take any input. Just complete the strstr() function. The function returns -1 if no match if found else it returns an integer denoting the first occurrence of the x in the string s.

Constraints:
1 <= T <= 200
1<= |s|,|x| <= 1000

Example:
Input
2
GeeksForGeeks Fr
GeeksForGeeks For
Output
-1
5

Explanation:
Testcase 1: Fr is not present in the string GeeksForGeeks as substring.
Testcase 2: For is present as substring in GeeksForGeeks from index 5.
 */

package com.Geeksforgeeks.strings;

import java.util.*;

public class ImplementStrStr {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String line = sc.nextLine();
            String a = line.split(" ")[0];
            String b = line.split(" ")[1];

            GfG g = new GfG();
            System.out.println(g.strstr(a, b));

            t--;
        }
    }
}

class GfG {
    int strstr(String str, String target) {
        // Your code here
        //One Way:
        // return str.indexOf(target);
        if (str == null || target.length() > str.length()) {
            return -1;
        }

        if (target == null || target.length() == 0) {
            return 0;
        }

        for (int i = 0; i <= str.length() - target.length(); i++) {
            int j;
            for (j = 0; j < target.length(); j++) {
                if (target.charAt(j) != str.charAt(i + j)) {
                    break;
                }
            }

            if (j == target.length()) {
                return i;
            }
        }

        return -1;
    }
}
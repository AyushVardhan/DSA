/*
Given a String of length S, reverse the whole string without reversing the individual words in it. Words are separated by dots.

Input:
The first line contains T denoting the number of testcases. T testcases follow. Each case contains a string S containing characters.

Output:
For each test case, in a new line, output a single line containing the reversed String.

Constraints:
1 <= T <= 100
1 <= |S| <= 2000

Example:
Input:
2
i.like.this.program.very.much
pqr.mno

Output:
much.very.program.this.like.i
mno.pqr
 */

package com.Geeksforgeeks.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            char[] inp = br.readLine().trim().toCharArray();
            StringBuffer sbr = new StringBuffer();
            List<String> list = new ArrayList<>();
            int flag = 0;

            for (int i = 0; i < inp.length; i++) {
                if (inp[i] == '.') {
                    flag = 1;
                    list.add(sbr.toString());
                    sbr.delete(0, i);
                } else {
                    sbr.append(inp[i]);
                }

                if (i == inp.length - 1 && !sbr.toString().isEmpty() && flag==1) {
                    list.add(sbr.toString());
                    sbr.delete(0, i);
                }
            }

            for (int i = list.size() - 1; i >= 0; i--) {
                if (i==0){
                    sbr.append(list.get(i));
                }else {
                    sbr.append(list.get(i)).append(".");
                }
            }

            System.out.println(sbr);
        }
    }
}

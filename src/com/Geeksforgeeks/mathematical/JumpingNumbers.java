/*
Given a positive number X. Find all Jumping Numbers smaller than or equal to X.
Jumping Number: A number is called Jumping Number if all adjacent digits in it differ by only 1. All single digit numbers are considered as Jumping Numbers. For example 7, 8987 and 4343456 are Jumping numbers but 796 and 89098 are not.

Input:
The first line of the input contains T denoting the number of testcases. Each testcase contain a positive number X.

Output:
Output all the jumping numbers less than X in sorted order. Jump to example for better understanding.

Constraints:
1 <= T <= 100
1 <= N <= 109

Example:
Input:
2
10
50
Output:
0 1 2 3 4 5 6 7 8 9 10
0 1 2 3 4 5 6 7 8 9 10 12 21 23 32 34 43 45

Explanation:
Testcase 2: Here, the most significant digits of each jumping number is following increasing order, i.e., jumping numbers starting from 0, followed by 1, then 2 and so on, themselves being in increasing order 2, 21, 23.
 */
package com.Geeksforgeeks.mathematical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class JumpingNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            String input = br.readLine();
            List<Integer> list = new ArrayList<>();
            list.add(0);

            LinkedList<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= 9; i++) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    int tmp = queue.remove();
                    if (tmp > Integer.parseInt(input)) continue;
                    list.add(tmp);
                    int leftmost = tmp % 10;
                    if (leftmost > 0) {
                        queue.add(tmp * 10 + (leftmost - 1));
                    }
                    if (leftmost < 9) {
                        queue.add(tmp * 10 + (leftmost + 1));
                    }
                }
            }
            Collections.sort(list);
            for (int i = 0 ; i < list.size() ; i++){
                if(i==list.size()-1){
                    System.out.print(list.get(i)+"");
                }else{
                    System.out.print(list.get(i)+" ");
                }
            }
            System.out.println();
        }
    }
}

/*
Somedays ago Leeana Learned about Fibonacci Number and then her uncle gave her a task. The task is to find the last two digits of nth Fibonacci number. The Fibonacci number sequence are: 0 1 1 2 3 5 8 13 21....... (0 based counting)

Note: Incase the fibonacci number is a single digit number print it with appending a 0 at its front ie for no 2 print 02.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains an integer n.

Output:
For each test case print the required answer in a new line.

Constraints:
1<=T<=100
0<=n<=10^18

Example:
Input:
2
0
7
Output:
00
13
 */

package com.Geeksforgeeks.puzzles;

import java.io.IOException;
import java.util.Scanner;

public class LastTwoDigitOfFibonacci {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long testCase = sc.nextLong();

        while (testCase-- > 0) {
            long n = sc.nextLong();
            int ans = fibonacci(n % 300);
            int countDigit = 0, tmp = ans;
            while (tmp > 0) {
                countDigit++;
                tmp = tmp / 10;
            }

            if (countDigit == 1 || ans == 0) {
                System.out.println("0" + ans);
            } else {
                System.out.println(ans);
            }
        }
    }

    private static int fibonacci(long n) {
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = (a + b) % 100;
            a = b;
            b = sum;
        }
        if (n == 1) {
            sum = 1;
        }
        return sum;
    }
}
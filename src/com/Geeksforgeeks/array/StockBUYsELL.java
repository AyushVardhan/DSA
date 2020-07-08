/*

Stock Buy Sell to Maximize Profit
The cost of a stock on each day is given in an array, find the max profit that you can make by buying and selling in those days. For example, if the given array is {100, 180, 260, 310, 40, 535, 695}, the maximum profit can earned by buying on day 0, selling on day 3. Again buy on day 4 and sell on day 6. If the given array of prices is sorted in decreasing order, then profit cannot be earned at all.

The cost of stock on each day is given in an array A[] of size N. Find all the days on which you buy and sell the stock so that in between those days your profit is maximum.

Input:
First line contains number of test cases T. First line of each test case contains an integer value N denoting the number of days, followed by an array of stock prices of N days.

Output:
For each testcase, output all the days with profit in a single line. And if there is no profit then print "No Profit".

Constraints:
1 <= T <= 100
2 <= N <= 103
0 <= Ai <= 104

Example
Input:
2
7
100 180 260 310 40 535 695
10
23 13 25 29 33 19 34 45 65 67

Output:
(0 3) (4 6)
(1 4) (5 9)

Explanation:
Testcase 1: We can buy stock on day 0, and sell it on 3rd day, which will give us maximum profit.

Note: Output format is as follows - (buy_day sell_day) (buy_day sell_day)
For each input, output should be in a single line.
 */

package com.Geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StockBUYsELL {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            int size = Integer.parseInt(br.readLine());
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] arr = new int[size]; //to store the index of smallest stock price till date

            arr[0] = 0;
            int minIndex = 0;
            StringBuffer print = new StringBuffer();
            for (int i = 1; i < size; i++) {
                if (input[i] >= input[i - 1]) {
                    arr[i] = minIndex;
                } else {
                    minIndex = i;
                    arr[i] = minIndex;
                }
            }
            int diff = -1, start = -1, end = -1;
            for (int i = 1; i < size; i++) {
                int tmp = input[i] - input[arr[i]];
                if (input[i] > input[arr[i]]) {
                    if (diff <= tmp) {
                        start = arr[i];
                        end = i;
                        diff = tmp;
                    }
                    if (i==size-1){
                        print.append("(" + start + " " + end + ")");
                    }
                } else {
                    if (diff != -1) {
                        diff = -1;
                        print.append("(" + start + " " + end + ") ");
                    }
                }
            }
            if (start == -1) {
                print.append("No Profit");
            }

            System.out.println(print);
        }
    }
}
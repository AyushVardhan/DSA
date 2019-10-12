/*
Given a sorted array A of size N. The function remove_duplicate takes two arguments . The first argument is the sorted array A[ ] and the second argument is 'N' the size of the array and returns the size of the new converted array A[ ] with no duplicate element.

Input Format:
The first line of input contains T denoting the no of test cases . Then T test cases follow . The first line of each test case contains an Integer N and the next line contains N space separated values of the array A[ ] .

Output Format:
For each test case output will be the transformed array with no duplicates.

Your Task:
Your task to complete the function remove_duplicate which removes the duplicate  elements from the array .

Constraints:
1 <= T <= 100
1 <= N <= 104
1 <= A[ ] <= 106

Example:
Input  (To be used only for expected output) :
2
5
2 2 2 2 2
3
1 2 2
Output
2
1 2
 */

package com.array;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveDuplicateFromSorted {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int N = sc.nextInt();
            int a[] = new int[N];
            for (int i = 0; i < N; i++)
                a[i] = sc.nextInt();

            GfG_1 g = new GfG_1();
            int n = g.remove_duplicate(a);

            for (int i = 0; i < n; i++)
                System.out.print(a[i] + " ");

            System.out.println();

            T--;
        }
    }
}

class GfG_1 {
    int remove_duplicate(int a[]) {
        if (a.length > 1) {
            int[] b = new int[a.length];
            int count = 0;
            Arrays.fill(b, -1);
            for (int i = 0, j = 0; i < a.length; i++) {
                if (i == a.length - 1) {
                    if (a[i] != a[i - 1]) {
                        b[j] = a[i];
                        j = j + 1;
                        count++;
                    }

                    if (a[i] == a[i - 1]) {
                        b[j] = a[i];
                        count++;
                    }
                } else {
                    if (a[i] == a[i + 1]) {
                        continue;
                    }
                    b[j] = a[i];
                    j = j + 1;
                    count++;
                }
            }
            for (int i = 0; i < count; i++) {
                a[i] = b[i];
            }
            return count;
        } else {
            return a.length;
        }
    }
}

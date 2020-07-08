/*
Given an array A of size N, your task is to do some operations, i.e., search an element, insert an element, and delete an element by completing the functions. Also, all functions should return a boolean value.

Input Format:
The first line of input consists of T, the number of test cases. T testcases follow. Each testcase contains 3 lines of input. The first line of every test case consists of an integer N, denotes the number of elements in an array. The second line of every test cases consists of N spaced integers Ai. The third line of every test case consists of four integers X, Y, Yi and Z, denoting the elements for the search operation, insert operation, insert operation element index and delete operation respectively.

Output Format:
For each testcase, return 1 for each operation if done successfully else 0.

Your Task:
Since this is a function problem, you only need to complete the provided functions.

Constraints:
1 <= T <= 100
1 <= N <= 100
1 <= Ai <= 100

Example:
Input:
1
5
2 4 1 0 6
1 2 2 0
Output:
1 1 1
 */

package com.Geeksforgeeks.array;

import java.util.Arrays;
import java.util.Scanner;

public class OperationOnArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[10000];
            Arrays.fill(a, -1);
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int x = sc.nextInt();
            int y = sc.nextInt();
            int yi = sc.nextInt();
            int z = sc.nextInt();
            GfG g = new GfG();
            boolean b = g.searchEle(a, x);
            if (b == true)
                System.out.print("1 ");
            else
                System.out.print("0 ");
            b = g.insertEle(a, y, yi);
            if (b) {
                if (a[yi] == y)
                    System.out.print("1 ");
                else
                    System.out.print("0 ");
            } else
                System.out.print("0 ");
            b = g.deleteEle(a, z);
            if (b) {
                if (!g.searchEle(a, z))
                    System.out.println("1 ");
                else
                    System.out.println("0 ");
            } else
                System.out.println("0 ");
        }
    }
}

class GfG {
    public boolean searchEle(int a[], int x) {
        for (int i = 0; i < a.length && a[i] != -1; i++) {
            if (a[i] == x) {
                return true;
            }
        }
        return false;
    }

    public boolean insertEle(int a[], int y, int yi) {
        int n = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == -1) {
                break;
            }
            n++;
        }
        if (yi >= 0 && yi <= n - 1) {
            for (int i = n - 1; i >= yi; i--) {
                a[i + 1] = a[i];
            }
            a[yi] = y;
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteEle(int a[], int z) {
        int index = -1, n = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == -1) {
                break;
            }
            n++;
        }
        for (int i = 0; i < a.length && a[i] != -1; i++) {
            if (a[i] == z) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int j = index; j < n; j++) {
                a[j] = a[j + 1];
            }
        }
        return true;
    }
}
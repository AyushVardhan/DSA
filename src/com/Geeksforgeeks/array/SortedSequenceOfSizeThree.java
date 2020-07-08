/*
Given an array A of N integers, Your task is to complete the function find3Numbers which finds any 3 elements in it such that A[i] < A[j] < A[k] and i < j < k. You need to return them as a vector, if no such element is present then return the empty vector of size 0.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. The first line of each test case contains an integer N denoting the size of the array A in the next line are N space separated values of the array A.

Output:
For each test case in a new line output will be 1 if the sub-sequence returned by the function is present in array A else 0.

Constraints:
1 <= T <= 100
1 <= N <= 105
1 <= A[ ] <= 106

Example:
Input:
2
5
1 2 1 1 3
3
1 1 3
Output:
1
0

Explanation:
There are 2 test cases
For first test case
a sub-sequence 1 2 3 exist
For second test case
no such sub-sequence exist
 */

/*
NOTE : Also possible in Linear time ... Check GeeksForGeeks
 */

package com.Geeksforgeeks.array;

import java.util.*;

public class SortedSequenceOfSizeThree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int i = 0;
            int n = sc.nextInt();
            int[] a = new int[1000];
            while (i < n) {
                a[i] = sc.nextInt();
                i++;
            }
            ABC g = new ABC();
            ArrayList aa = g.find3Numbers(a, n);
            if (aa.size() == 3) {
                int x = (int) aa.get(0);
                int y = (int) aa.get(1);
                int z = (int) aa.get(2);
                if (x < y && y < z)
                    System.out.println("1");
                else
                    System.out.println("0");
            } else {
                System.out.println("0");
            }
        }
    }
}

class ABC {
    public static ArrayList find3Numbers(int[] a, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int count;

        for (int i = 0; i < n - 2; i++) {
            list.clear();
            int max = a[i];
            list.add(max);
            count = 1;

            for (int j = i + 1; j < n; j++) {
                if (count == 3) {
                    break;
                }

                if (a[j] > max) {
                    max = a[j];
                    count++;
                    list.add(max);
                }
            }

            if (count == 3) {
                break;
            }
        }

        return list;
    }
}
/*
Given an array A of N elements. Find the majority element in the array. A majority element in an array A of size N is an element that appears more than N/2 times in the array.

Input:
The first line of the input contains T denoting the number of testcases. The first line of the test case will be the size of array and second line will be the elements of the array.

Output:
For each test case the output will be the majority element of the array. Output "-1" if no majority element is there in the array.

Constraints:
1 <= T<= 100
1 <= N <= 107
0 <= Ai <= 106

Example:
Input:
2
5
3 1 3 3 2
3
1 2 3

Output:
3
-1

Explanation:
Testcase 1: Since, 3 is present more than N/2 times, so it is the majority element.
 */

package com.Geeksforgeeks.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MajorityElement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCase = in.nextInt();

        while (testCase-- > 0){
            int size = in.nextInt();
            Map<Integer,Integer> map = new HashMap<>();

            for (int i = 0 ; i < size ; i++){
                int n = in.nextInt();
                if (map.containsKey(n)){
                    map.put(n,map.get(n)+1);
                }else{
                    map.put(n,1);
                }
            }

            int max = 0, key = 0, flag = 0;
            for (Map.Entry<Integer,Integer> entry : map.entrySet()){
                if (entry.getValue() > max){
                    max = entry.getValue();
                    key = entry.getKey();

                    if (max > (size/2)){
                        flag = 1;
                        break;
                    }
                }
            }

            if (flag==1){
                System.out.println(key);
            }else{
                System.out.println(-1);
            }

        }
    }
}

/*
Find out the maximum sub-array of non negative numbers from an array.
The sub-array should be continuous. That is, a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).

Example:
A : [1, 2, 5, -7, 2, 3]
The two sub-arrays are [1, 2, 5] [2, 3].
The answer is [1, 2, 5] as its sum is larger than [2, 3]

NOTE 1: If there is a tie, then compare with segment's length and return segment which has maximum length
NOTE 2: If there is still a tie, then return the segment with minimum starting index

Input:
The first line contains an integer T, depicting total number of test cases.
Then following T lines contains an integer N depicting the size of array and next line followed by the value of array.

Output:
Print the Sub-array with maximum sum.

Constraints:
1 ≤ T ≤ 40
1 ≤ N ≤ 100
-100 ≤ A[i] ≤ 100

Example:
Input
2
3
1 2 3
2
-1  2
Output
1 2 3
2
 */

package com.Geeksforgeeks.array;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaximumSubArrayOfNonNegative {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int testCase = in.nextInt();

        while (testCase-- > 0) {
            int size = in.nextInt();
            int input[] = new int[size];
            for (int i = 0 ; i < size ; i++){
                input[i] = in.nextInt();
            }

            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < size; i++) {
                if (input[i] < 0) {
                    continue;
                }
                int start = i;
                while (i < size && input[i] >= 0) {
                    i++;
                }
                map.put(start, i - 1);
            }

            int sum = 0, start = 0, end = 0;
            for ( Map.Entry<Integer,Integer> entry : map.entrySet() ) {
                int tmp = 0;
                for (int i = entry.getKey(); i <= entry.getValue(); i++){
                    tmp = tmp + input[i];
                }
                if (tmp > sum){
                    sum = tmp;
                    start = entry.getKey();
                    end = entry.getValue();
                }else if(tmp == sum){
                    int diff1 = entry.getValue() - entry.getKey();
                    int diff2 = end - start;
                    if(diff1 > diff2){
                        start = entry.getKey();
                        end = entry.getValue();
                    }else if(diff1==diff2){
                        if(entry.getKey() <= start){
                            start = entry.getKey();
                            end = entry.getValue();
                        }

                        if(input[start]<0){
                            start = entry.getKey();
                            end = entry.getValue();
                        }
                    }
                }
            }

            for (int i = start; i<= end; i++){
                System.out.print(input[i]+" ");
            }
            System.out.println();
        }
    }
}

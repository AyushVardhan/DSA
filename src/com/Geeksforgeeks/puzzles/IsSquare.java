/*
Given four different points in space. Find whether these points can form a square or not.

Input:
The first line of input contains an integer T denoting the number of test cases.
The first line of each testcase contains x1, y1, x2, y2, x3, y3, x4, y4(four points coordinates) separated by space.

Output:
Print "Yes"(without quotes) if it is square else "No"(without quotes).

Constraints:
1 ≤ T ≤ 30
1 ≤ x1, x2, x3, x4, y1, y2, y3, y4 ≤ 100

Example:
Input:
1
20 10 10 20 20 20 10 10

Output:
Yes
 */

package com.Geeksforgeeks.puzzles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class IsSquare {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0){
            String[] coordinates = br.readLine().split(" ");
            Set<String> points = new HashSet<>();
            for (int i = 0 ; i < coordinates.length ; i++){
                points.add(coordinates[i]);
            }
            if(points.size()==2){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }
}

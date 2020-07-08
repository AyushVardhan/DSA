/*
Given two rectangles, find if the given two rectangles overlap or not. A rectangle is denoted by providing the x and y co-ordinates of two points: the left top corner and the right bottom corner of the rectangle. Two rectangles sharing a side are considered overlapping.

Note : It may be assumed that the rectangles are parallel to the coordinate axis.

Input:
The first integer T denotes the number of testcases. For every test case, there are 2 lines of input. The first line consists of 4 integers: denoting the co-ordinates of the 2 points of the first rectangle. The first integer denotes the x co-ordinate and the second integer denotes the y co-ordinate of the left topmost corner of the first rectangle. The next two integers are the x and y co-ordinates of right bottom corner. Similarly, the second line denotes the cordinates of the two points of the second rectangle in similar fashion.

Output:
For each testcase, output (either 1 or 0) denoting whether the 2 rectangles are overlapping. 1 denotes the rectangles overlap whereas 0 denotes the rectangles do not overlap.

Constraints:
1 <= T <= 10
-104 <= x, y <= 104

Example:
Input:
2
0 10 10 0
5 5 15 0
0 2 1 1
-2 -3 0 2

Output:
1
0

Explanation:
Testcase 1: Given two rectangles overlap each other thus answer returns 1.
 */

package com.Geeksforgeeks.puzzles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OverlappingRectangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0){
            String[] rectangle1 = br.readLine().split(" ");
            String[] rectangle2 = br.readLine().split(" ");
            int Ax1 =  Integer.parseInt(rectangle1[0]); int Bx1 =  Integer.parseInt(rectangle2[0]);
            int Ay1 =  Integer.parseInt(rectangle1[1]); int By1 =  Integer.parseInt(rectangle2[1]);
            int Ax2 =  Integer.parseInt(rectangle1[2]); int Bx2 =  Integer.parseInt(rectangle2[2]);
            int Ay2 =  Integer.parseInt(rectangle1[3]); int By2 =  Integer.parseInt(rectangle2[3]);

            if(Ax1 > Bx2 || Ax2 < Bx1 || Ay2 > By1 || Ay1 < By2)
                System.out.println(0);
            else System.out.println(1);
        }
    }
}

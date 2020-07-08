/*
Write a program that calculates the day of the week for any particular date in the past or future.

Input:

The first line of input contains a single integer T denoting the number of test cases. Then T test cases follow. Each test case consist of one line. The first line of each test case consists of an integer d,m and y, d is day, m is month and y is the year.

Output:

Print day of given date.

Constraints:

1 ≤ T ≤ 100
1990 ≤ Y ≤ 2100

Example:

Input:

2

28 12 1995

30 8 2010

Output

Thursday

Monday
 */

package com.Geeksforgeeks.puzzles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

enum Day
{
    D0("Sunday"), D1("Monday"), D2("Tuesday"), D3("Wednesday"), D4("Thursday"), D5("Friday"), D6("Saturday"), D7("Sunday");

    private String day;

    Day(String day) {
        this.day = day;
    }

    public String getDay(){
        return this.day;
    }
}

public class DayOfWeek {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            String[] input = br.readLine().split(" ");
            int day = Integer.parseInt(input[0]);
            int month = Integer.parseInt(input[1]);
            int year = Integer.parseInt(input[2]);
            int day_of_week = tomohiko_sakamoto(year,month,day);
            Day dow = Day.valueOf("D"+day_of_week);
            System.out.println(dow.getDay());
        }
    }

    public static int tomohiko_sakamoto(int y, int m, int d)
    {
        int t[] = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 };
        if (m < 3)
            y -= 1;
        return (y + y / 4 - y / 100 + y / 400 + t[m - 1] + d) % 7;
    }
}

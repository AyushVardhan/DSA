/*
Given two strings of lowercase alphabets and a value K, your task is to complete the given function which tells if  two strings are K-anagrams of each other or not.
Two strings are called K-anagrams if both of the below conditions are true.
1. Both have same number of characters.
2. Two strings can become anagram by changing at most K characters in a string.

Input Format:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. The first line of input contains two Strings Str1 and Str2. And next line contains an integer K, which denotes number of characters can be replaced.

Output Format:
For each testcase, in a new line, print the respective output.

Your Task:
Since this is a function problem, you don't need to take any input. Just complete the given function areKAnagrams that returns true if the strings can be turned into K-anagrams, else return false.

Constraints:
1 <= T <= 100
1 <= K <= |length of String|

Example:
Input:
1
fodr gork
2
Output:
1

Explanation:
Testcase1: change fd to gk
 */

package com.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckingTwoStringForKAnagrams {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            String[] inp = br.readLine().split(" ");
            String str1 = inp[0];
            String str2 = inp[1];
            int k = Integer.parseInt(br.readLine());

            System.out.println(areKAnagram(str1, str2, k));
        }
    }

    private static boolean areKAnagram(String s1, String s2, int k) {
        int freq[]=new int[26];
        if(s1.length() != s2.length())
            return false;

        for(int i=0;i<s1.length();i++)
            freq[s1.charAt(i)-'a']++;

        for(int i=0;i<s2.length();i++)
            freq[s2.charAt(i)-'a']--;

        int sum=0;
        for(int i=0;i<26;i++)
            if(freq[i]>0)
                sum+=freq[i];
        return (k>=sum);
    }
}

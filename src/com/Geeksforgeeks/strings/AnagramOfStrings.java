package com.Geeksforgeeks.strings;

import java.util.*;
public class AnagramOfStrings{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String s=sc.next();
            String s1=sc.next();
            GfG1 g=new GfG1();
            System.out.println(g.remAnagrams(s,s1));
        }
    }
}


class GfG1
{
    public int remAnagrams(String s,String s1)
    {
        int a[] = new int[26];
        int sum = 0;

        for (int i = 0; i< s.length(); i++){
            a[s.charAt(i)-'a']++;
        }

        for (int i = 0; i< s1.length(); i++){
            a[s1.charAt(i)-'a']--;
        }

        for (int i = 0; i < 26; i++){
            if (a[i]<0){
                a[i] *= -1;
            }
            sum += a[i];
        }

        return sum;
    }
}
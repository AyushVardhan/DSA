package com.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveAdjacentDuplicate {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());
        while (tests-- > 0){
            System.out.println(remove(br.readLine().trim()));;
        }
    }

    static String removeUtil(String str, char last_removed) {
        if (str.length() == 0 || str.length() == 1)//1
            return str;
        if (str.charAt(0) == str.charAt(1))//2
        {
            last_removed = str.charAt(0);
            while (str.length() > 1 && str.charAt(0) == str.charAt(1))
                str = str.substring(1, str.length());
            str = str.substring(1, str.length());
            return removeUtil(str, last_removed);
        }
        String rem_str = removeUtil(str.substring(1, str.length()), last_removed);//3
        if (rem_str.length() != 0 && rem_str.charAt(0) == str.charAt(0))//4
        {
            last_removed = str.charAt(0);
            return rem_str.substring(1, rem_str.length()); // Remove first character
        }
        if (rem_str.length() == 0 && last_removed == str.charAt(0))//5
            return rem_str;
        return (str.charAt(0) + rem_str);//6
    }

    static String remove(String str) {
        char last_removed = '\0';
        return removeUtil(str, last_removed);
    }
}

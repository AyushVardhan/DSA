package com.Geeksforgeeks.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KthCharacter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());

        while (tests-- > 0) {
            String[] inps = br.readLine().split(" ");
            int m = Integer.parseInt(inps[0]);
            int k = Integer.parseInt(inps[1]);
            int n = Integer.parseInt(inps[2]);

            StringBuilder str = new StringBuilder();
            String[] s;
            String s1;

            while (m > 0) {
                str.append(m % 2);
                m = m / 2;
            }

            s1 = ReverseString(String.valueOf(str));

            for (int i = 0; i < n ; i++){
                s = s1.split("");
                for (int j = 0; j < s.length; j++){
                    if (s[j].equals("0")){
                        s[j] = "01";
                    }else {
                        s[j] = "10";
                    }
                }

                s1 = "";

                for (int j = 0; j < s.length; j++){
                    s1 = s1 + s[j];
                }
            }

            System.out.println(s1.charAt(k));
        }
    }

    static String ReverseString(String s)
    {
        char[] arr = s.toCharArray();
        for(int i = 0;
            i < arr.length / 2; i++)
        {
            char temp = arr[i];
            arr[i] = arr[arr.length - i -1];
            arr[arr.length - i - 1] = temp;
        }
        return new String(arr);
    }
}
// Till now solution was of O(n square). Lets see solution of O(log z), where z is size of block at nth iteration

//https://www.geeksforgeeks.org/find-ith-index-character-in-a-binary-string-obtained-after-n-iterations-set-2/
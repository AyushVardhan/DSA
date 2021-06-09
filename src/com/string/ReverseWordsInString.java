package com.string;

public class ReverseWordsInString {
    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
    }

    private static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] str = s.trim().split(" ");


        for (int i = str.length-1; i >= 0; i--) {
            if (str[i].length() == 0)
                continue;
            if (i == 0) {
                sb.append(str[i].trim());
            } else {
                sb.append(str[i].trim()+" ");
            }
        }

        return sb.toString();
    }
}

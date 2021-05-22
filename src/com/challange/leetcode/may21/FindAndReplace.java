package com.challange.leetcode.may21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplace {
    public static void main(String[] args) {
        String[] words = new String[]{"ccd", "cba", "xyx", "yxx", "yyx"};
        System.out.println(findAndReplacePattern(words, "aab"));
    }

    private static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> resList = new ArrayList<>();

        for (String word : words) {
            if (isMatchingPattern(word, pattern)) {
                resList.add(word);
            }
        }

        return resList;
    }

    private static boolean isMatchingPattern(String word, String pattern) {

        Map<Character, Character> M = new HashMap();
        for (int i = 0; i < word.length(); ++i) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if (!M.containsKey(w)) M.put(w, p);
            if (M.get(w) != p) return false;
        }

        boolean[] seen = new boolean[26];
        for (char p: M.values()) {
            if (seen[p - 'a']) return false;
            seen[p - 'a'] = true;
        }
        return true;
    }
}

package com.Leetcode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab","eidbaooo"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(s1map, s2map))
                return true;
            s2map[s2.charAt(i + s1.length()) - 'a']++;
            s2map[s2.charAt(i) - 'a']--;
        }
        return matches(s1map, s2map);
    }
    public static boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }

//    public static boolean checkInclusion(String s1, String s2) {
//        Map<Character, Integer> patMap = new HashMap<>();
//        for (char chr : s1.toCharArray()){
//            patMap.put(chr, patMap.getOrDefault(chr, 0) + 1);
//        }
//
//        int l = 0, count = 0;
//        for (int r = 0; r < s2.length(); r++) {
//            char rc = s2.charAt(r);
//            if (patMap.containsKey(rc)){
//                patMap.put(rc, patMap.get(rc) - 1);
//                if (patMap.get(rc) == 0)
//                    count++;
//            }
//
//            if (count == patMap.size())
//                return true;
//
//            if (r >= s1.length()-1){
//                char lc = s2.charAt(l++);
//                if (patMap.containsKey(lc)) {
//                    if (patMap.get(lc) == 0)
//                        count--;
//                    patMap.put(lc, patMap.get(lc)+1);
//                }
//            }
//        }
//
//        return false;
//    }
}

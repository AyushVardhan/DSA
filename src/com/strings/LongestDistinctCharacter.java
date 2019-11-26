package com.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LongestDistinctCharacter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine().trim());

        while (testCase-- > 0) {
            String str = br.readLine().trim();
            System.out.println(longestUniqueSubsttr(str));
        }
    }

    static int longestUniqueSubsttr(String str)
    {
        int n = str.length();
        int cur_len = 1;
        int max_len = 1;
        int prev_index;
        int i;
        int visited[] = new int[256];

        Arrays.fill(visited,-1);
        visited[str.charAt(0)] = 0;

        for (i = 1; i < n; i++) {
            prev_index = visited[str.charAt(i)];

            if (prev_index == -1 || i - cur_len > prev_index)
                cur_len++;
            else {
                cur_len = i - prev_index;
            }

            if (cur_len > max_len)
                max_len = cur_len;

            visited[str.charAt(i)] = i;
        }
        return max_len;
    }
}

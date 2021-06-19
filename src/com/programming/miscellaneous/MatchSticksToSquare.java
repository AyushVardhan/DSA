package com.programming.miscellaneous;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatchSticksToSquare {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.println(s1.makesquare(new int[]{5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3}));
    }

    static class Solution {

        List<Integer> list = new ArrayList<>();
        int[] sums = new int[4];
        int expectedSideLength = 0;

        public boolean makesquare(int[] matchsticks) {

            if (matchsticks.length == 0)
                return false;

            int perimeter = 0;
            for (int len : matchsticks) {
                perimeter += len;
                list.add(len);
            }

            Collections.sort(list, Collections.reverseOrder());
            expectedSideLength = perimeter / 4;
            if (perimeter % 4 != 0) {
                return false;
            }
            return dfs(0);
        }

        private boolean dfs(int index) {
            if (index == list.size()) {
                return sums[0] == sums[1] && sums[1] == sums[2] && sums[2] == sums[3];
            }

            int element = list.get(index);

            for(int i = 0; i < 4; i++) {
                if (sums[i] + element <= expectedSideLength) {
                    sums[i] += element;
                    if (dfs(index + 1)) {
                        return true;
                    }
                    sums[i] -= element;
                }
            }

            return false;
        }
    }
}

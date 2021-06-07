package com.array;

import java.util.*;

public class ReduceOpsAndMakeArrayElemEquals {
    public static void main(String[] args) {
        System.out.println(reductionOperations(new int[]{1, 2, 1}));
    }

    private static int reductionOperations(int[] n) {
        int res = 0, sz = n.length;
        Arrays.sort(n);
        for (int j = sz - 1; j > 0; --j)
            if (n[j - 1] != n[j])
                res += sz - j;
        return res;

    }
}

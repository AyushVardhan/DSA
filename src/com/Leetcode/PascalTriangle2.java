package com.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {
    public static void main(String[] args) {
        System.out.println(getRow(0));
    }

    private static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if (rowIndex <= 0){
            list.add(1);
            return list;
        }

        int[] res = new int[rowIndex + 1];
        int[] tmp = new int[rowIndex + 1];
        tmp[0] = 1;

        for (int i = 1; i <= rowIndex; i++) {
            for (int j = 0; j <= rowIndex; j++) {
                if (j == 0)
                    res[j] = 1;
                else {
                    int integer = tmp[j] + tmp[j - 1];
                    if (integer == 0)
                        break;
                    res[j] = integer;
                }
            }

            System.arraycopy(res, 0, tmp, 0, res.length);
        }

        for (int d : res){
            list.add(d);
        }
        return list;
    }
}

package com.programming.twopointers.leetcode;

import java.util.Arrays;

public class RotateTheBox {
    public static void main(String[] args) {
        char[][] box = {{'#', '#', '*', '.', '*', '.'},
                        {'#', '#', '#', '*', '.', '.'},
                        {'#', '#', '#', '.', '#', '.'}};

        System.out.println(Arrays.deepToString(rotateTheBox(box)));
    }

    private static char[][] rotateTheBox(char[][] box) {
        int n = box[0].length;

        for (int i = 0; i < box.length; i++) {
            for (int r = n - 1; r >= 0; r--) {
                if (box[i][r] == '#' || box[i][r] == '*')
                    continue;

                if (r > 0 && box[i][r] == '.') {
                    int right = r;
                    while (r >= 0 && box[i][r] == '.')
                        r--;

                    int l = r; boolean flag = true;
                    while (right >= 0 && l >= 0 && (box[i][l] == '#' || box[i][l] == '*')) {
                        if (box[i][l] == '*') {
                            flag = false;
                            break;
                        }

                        box[i][right--] = '#';
                        box[i][l--] = '.';
                    }

                    if (flag && l != -1 && box[i][l + 1] == '.')
                        r = right+1;
                }
            }
        }

        return transpose(box);
    }

    private static char[][] transpose(char[][] box) {
        char[][] res = new char[box[0].length][box.length];

        int k = 0;
        for (int i = box.length-1; i >= 0; i--) {
            for (int j = 0; j < box[0].length; j++) {
                res[j][k] = box[i][j];
            }
            k++;
        }

        return res;
    }

    //    private static char[] rotateTheBoxRow(char[] box) {
//        int n = box.length;
//
//        for (int r = n - 1; r >= 0; r--) {
//            if (box[r] == '#' || box[r] == '*')
//                continue;
//
//            if (r > 0 && box[r] == '.') {
//                int right = r;
//                while (r >= 0 && box[r] == '.')
//                    r--;
//
//                int l = r; boolean flag = true;
//                while (right >= 0 && l >= 0 && (box[l] == '#' || box[l] == '*')) {
//                    if (box[l] == '*') {
//                        flag = false;
//                        break;
//                    }
//
//
//                    box[right--] = '#';
//                    box[l--] = '.';
//                }
//
//                if (flag && l != -1 && box[l + 1] == '.')
//                    r = right+1;
//            }
//        }
//
//        return box;
//    }
}

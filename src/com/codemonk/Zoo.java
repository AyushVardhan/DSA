package com.codemonk;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Zoo {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] name = br.readLine().trim().split("");

        int zCount = 0;
        int oCount = 0;

        for (int i = 0; i <= name.length / 2; i++) {
            if (i == 0 && name[i].equals("z")) {
                zCount++;
            } else if (i == 0) {
                break;
            } else if (name[i].equals(name[i - 1])) {
                zCount++;
            } else if (zCount >= name.length / 2) {
                break;
            } else {
                break;
            }
        }

        oCount = name.length - zCount;

        if (zCount != 0 && zCount * 2 == oCount) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}

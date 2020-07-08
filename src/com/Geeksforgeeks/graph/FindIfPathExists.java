package com.Geeksforgeeks.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindIfPathExists {

    static int X[] = new int[]{1, 0, -1, 0};
    static int Y[] = new int[]{0, 1, 0, -1};

    static boolean validPath(int x, int y, int n) {
        if (x >= 0 && y >= 0 && x < n && y < n) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int arr[][] = new int[n][n];
            Pair s = null, d = null;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = in.nextInt();

                    if (arr[i][j] == 1) s = new Pair(i, j);
                    if (arr[i][j] == 2) d = new Pair(i, j);
                }
            }

            boolean vis[][] = new boolean[n][n];
            boolean pathFound = false;
            Queue<Pair> queue = new LinkedList<>();

            queue.add(s);
            while (!queue.isEmpty()) {
                Pair p = queue.poll();
                vis[p.x][p.y] = true;

                for (int i = 0; i < 4; i++) {
                    int x = p.x + X[i];
                    int y = p.y + Y[i];

                    if (validPath(x, y, n)) {
                        if (arr[x][y] == 2) {
                            pathFound = true;
                            break;
                        }

                        if (!vis[x][y] && arr[x][y] == 3) {
                            queue.add(new Pair(x, y));
                        }
                    }
                }

                if (pathFound) {
                    break;
                }
            }

            if (pathFound)
                System.out.println(1);
            else System.out.println(0);
        }
    }
}

class Pair {
    int x, y;

    Pair(int x1, int y1) {
        x = x1;
        y = y1;
    }
}
package com.Geeksforgeeks.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair1 {
    int x, y;

    Pair1(int x1, int y1) {
        x = x1;
        y = y1;
    }
}


public class KnightWalk {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int nm[] = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = nm[0];
            int m = nm[1];
            nm = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int sx = nm[0];
            int sy = nm[1];
            int dx = nm[2];
            int dy = nm[3];

            System.out.println(getMinMoves(n, m, sx - 1, sy - 1, dx - 1, dy - 1));
        }
    }

    private static int getMinMoves(int n, int m, int sx, int sy, int dx, int dy) {
        boolean[][] vis = new boolean[n][m];
        Queue<Pair1> q = new LinkedList<>();
        Queue<Integer> dq = new LinkedList<>();
        Pair1 s = new Pair1(sx, sy);
        vis[sx][sy] = true;
        q.add(s);
        dq.add(0);
        int[] xmove = {2, -1, 1, -2, 1, -1, 2, -2};
        int[] ymove = {-1, -2, -2, 1, 2, 2, 1, -1};
        int d = 0;
        while (!q.isEmpty()) {
            Pair1 u = q.remove();
            d = dq.remove();
            if (u.x == dx && u.y == dy)
                return d;
            for (int k = 0; k < 8; k++) {
                int x = u.x + xmove[k];
                int y = u.y + ymove[k];
                if (x >= 0 && x < n && y >= 0 && y < m && !vis[x][y]) {
                    vis[x][y] = true;
                    q.add(new Pair1(x, y));
                    dq.add(d + 1);
                }
            }
        }
        return -1;
    }
}

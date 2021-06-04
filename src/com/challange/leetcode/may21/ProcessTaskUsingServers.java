package com.challange.leetcode.may21;

import java.util.*;

public class ProcessTaskUsingServers {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(assignTasks(new int[]{3, 3, 2}, new int[]{1, 2, 3, 2, 1, 2})));
    }


    private static int[] assignTasks(int[] servers, int[] tasks) {

        if (servers.length == 0)
            return new int[tasks.length];

        int[] res = new int[tasks.length];
        // based on weight, then index
        PriorityQueue<Server> availableServerQueue = new PriorityQueue<>((x, y) -> (x.weight != y.weight) ? x.weight - y.weight : x.idx - y.idx);
        // based on available time, then weight & then index
        PriorityQueue<Server> inUseServerQueue = new PriorityQueue<>((x, y) -> (x.time != y.time) ? x.time - y.time :
                                                                                (x.weight != y.weight) ? x.weight - y.weight : x.idx - y.idx);

        for (int i = 0; i < servers.length; i++) {
            availableServerQueue.add(new Server(i, servers[i], 0));
        }

        for (int i = 0; i < tasks.length; i++) {
            int t = tasks[i];
            while (!inUseServerQueue.isEmpty() && inUseServerQueue.peek().time <= i)
                availableServerQueue.add(inUseServerQueue.poll());

            if (availableServerQueue.isEmpty()) {
                Server inUseServer = inUseServerQueue.poll();
                res[i] = inUseServer.idx;
                inUseServer.time += t;
                inUseServerQueue.add(inUseServer);
            } else {
                Server availServer = availableServerQueue.poll();
                res[i] = availServer.idx;
                availServer.time = i + t;
                inUseServerQueue.add(availServer);
            }
        }
        return res;
    }
    static class Server {
        int idx;
        int weight;
        int time;

        public Server(int i, int w, int t) {
            this.idx = i;
            this.weight = w;
            this.time = t;
        }
    }
}
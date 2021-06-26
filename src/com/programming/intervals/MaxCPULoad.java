package com.programming.intervals;

import java.util.*;

public class MaxCPULoad {

    static class Job {
        int start;
        int end;
        int load;

        public Job(int st, int ed, int ld) {
            start = st;
            end = ed;
            load = ld;
        }
    }

    public static void main(String[] args) {
        Job job1 = new Job(6,7,10);
        Job job2 = new Job(2,4, 11);
        Job job3 = new Job(8,12,15);
        System.out.println(getMaxLoad(Arrays.asList(job1, job2, job3)));
    }

    private static int getMaxLoad(List<Job> jobList) {

        Collections.sort(jobList, (x,y) -> Integer.compare(x.start, y.start));
        PriorityQueue<Job> endQueue = new PriorityQueue<>((a,b) -> Integer.compare(a.end, b.end));

        int currentLoad = 0;
        int maxLoad = 0;

        for (Job job : jobList){
            while (!endQueue.isEmpty() && job.start > endQueue.peek().end) {
                currentLoad -= endQueue.poll().load;
            }

            endQueue.offer(job);
            currentLoad += job.load;
            maxLoad = Math.max(maxLoad, currentLoad);
        }

        return maxLoad;

    }
}

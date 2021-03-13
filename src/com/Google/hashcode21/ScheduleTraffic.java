package com.Google.hashcode21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ScheduleTraffic {

    static class StreetDetails {
        int start;
        int end;
        int travelTime;

        public StreetDetails(int start, int end, int travelTime) {
            this.start = start;
            this.end = end;
            this.travelTime = travelTime;
        }
    }

    static class PathDetails {
        int curr_time;
        List<String> pathList;
        boolean isDestReached;
        int curr_index;
        int totalPathDistance;
        int numberOfTraffics;

        public void setCurr_time(int curr_time) {
            this.curr_time = curr_time;
        }

        public void setDestReached(boolean destReached) {
            isDestReached = destReached;
        }

        public void setCurr_index(int curr_index) {
            this.curr_index = curr_index;
        }

        public PathDetails(int curr_time, List<String> pathList, boolean isDestReached, int curr_index, int totalPathDistance, int numberOfTraffics) {
            this.curr_time = curr_time;
            this.pathList = pathList;
            this.isDestReached = isDestReached;
            this.curr_index = curr_index;
            this.totalPathDistance = totalPathDistance;
            this.numberOfTraffics = numberOfTraffics;
        }
    }

    static class IntersectionSchedule {
        int time;
        String pathName;

        public void setTime(int time) {
            this.time = time;
        }

        public void setPathName(String pathName) {
            this.pathName = pathName;
        }

        public IntersectionSchedule(int time, String pathName) {
            this.time = time;
            this.pathName = pathName;
        }
    }

    static class CustomComparator implements Comparator<PathDetails> { // need to check of works or not

        @Override
        public int compare(PathDetails st1, PathDetails st2) {
            if (st1.totalPathDistance != st2.totalPathDistance) { // 1st pick shortest total path
                return st1.totalPathDistance - st2.totalPathDistance;
            } else {
                return st1.numberOfTraffics - st2.numberOfTraffics; // otherwise, Minimum number of intersections
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st1 = br.readLine().trim().split(" ");

        int simulationTime = Integer.parseInt(st1[0]);
        int totalIntervals = Integer.parseInt(st1[1]);
        int totalStreets = Integer.parseInt(st1[2]);
        int totalCars = Integer.parseInt(st1[3]);
        int scorePoint = Integer.parseInt(st1[4]);

        Map<String, StreetDetails> streetMap = new HashMap<>();
        List<PathDetails> pathList = new ArrayList<>();

        for (int i = 0; i < totalStreets; i++) {
            st1 = br.readLine().trim().split(" ");
            streetMap.put(st1[2],new StreetDetails(Integer.parseInt(st1[0]),Integer.parseInt(st1[1]),Integer.parseInt(st1[3])));
        }

        for (int i = 0; i < totalCars; i++) {
            st1 = br.readLine().trim().split(" ");
            int size = Integer.parseInt(st1[0]);
            List<String> path = new ArrayList<>(Arrays.asList(st1).subList(1, size + 1));

            int pathLength = 0;
            for (String pathId : path){
                pathLength += streetMap.get(pathId).travelTime;
            }

            pathList.add(new PathDetails(0,path , false, 0, pathLength, path.size()-1));
        }

        PriorityQueue<PathDetails> pathDetailsPriorityQueue = new PriorityQueue<>(new CustomComparator());
        // Add pathList to priorityQueue


        for (int t = 0; t <= simulationTime; t++) {

            Map<Integer, IntersectionSchedule> scheduleMap= new HashMap<>();

            // use list after extracting it from priority queue -- need to add this logic
            for (int i = 0; i < pathList.size(); i++){
                if (!pathList.get(i).isDestReached) {
                    PathDetails pathDetails = pathList.get(i);
                    String pathName = pathDetails.pathList.get(pathDetails.curr_index);
                    int currentIntersection = streetMap.get(pathName).end;

                    if (scheduleMap.containsKey(currentIntersection)){
                        if (scheduleMap.get(currentIntersection).pathName.equalsIgnoreCase(pathName)) {
                            IntersectionSchedule intersectionSchedule = scheduleMap.get(currentIntersection);
                            intersectionSchedule.setTime(intersectionSchedule.time + 1);
                            scheduleMap.put(currentIntersection, intersectionSchedule);
                        } else {
                            scheduleMap.put(currentIntersection, new IntersectionSchedule(1, pathName));
                        }
                    } else {
                        scheduleMap.put(currentIntersection, new IntersectionSchedule(1, pathName));
                    }

                    pathDetails.setCurr_index(pathDetails.curr_index++);
                    pathDetails.setCurr_time(pathDetails.curr_time + streetMap.get(pathName).travelTime);
                    if (pathDetails.curr_index == pathDetails.pathList.size() - 1) {
                        pathDetails.setDestReached(true);
                    }
                }
            }
        }
    }
}

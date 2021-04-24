package com.Leetcode.slidingWindow;

public class CircularTour {
    static class petrolPump {
        int petrol;
        int distance;

        // constructor
        public petrolPump(int petrol, int distance)
        {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        System.out.println(tour(new int[]{4,6,7,4}, new int[]{6,5,3,5}));
    }

    private static int tour(int[] petrol, int[] distance) {
        petrolPump[] arr = new petrolPump[petrol.length];
        for (int i = 0; i < petrol.length; i++){
            arr[i] = new petrolPump(petrol[i], distance[i]);
        }

        return printTour(arr, arr.length);
    }

    static int printTour(petrolPump arr[], int n)
    {
        int start = 0;
        int end = 1;
        int curr_petrol = arr[start].petrol - arr[start].distance;

        while(end != start || curr_petrol < 0)
        {

            while(curr_petrol < 0 && start != end)
            {
                curr_petrol -= arr[start].petrol - arr[start].distance;
                start = (start + 1) % n;


                if(start == 0)
                    return -1;
            }
            curr_petrol += arr[end].petrol - arr[end].distance;

            end = (end + 1)%n;
        }

        return start;
    }
}

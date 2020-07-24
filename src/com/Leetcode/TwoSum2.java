package com.Leetcode;

public class TwoSum2 {
    public static void main(String[] args) { // Here input is guaranteed to be ascending order
        int[] x = twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(x);
    }

    private static int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int h = numbers.length - 1;

        while (l < h) {
            if (numbers[l] + numbers[h] == target) {
                return new int[]{l + 1, h + 1};
            } else if (numbers[l] + numbers[h] > target) {
                h = largestSmallerOrLastEqual(numbers, l, h, target - numbers[l]);
            } else {
                l = SmallestLargestOrFirstEqual(numbers, l, h, target - numbers[h]);
            }
        }

        return new int[]{-1, -1};
    }

    private static int SmallestLargestOrFirstEqual(int[] numbers, int l, int h, int target) {
        while (l <= h){
            int mid = (l + h)/2;
            if (numbers[mid] < target)
                l = mid + 1;
            else h = mid -1;
        }

        return l;
    }

    private static int largestSmallerOrLastEqual(int[] numbers, int l, int h, int target) {
        while (l <= h){
            int mid = (l + h)/2;
            if (numbers[mid] > target)
                h = mid-1;
            else l = mid + 1;
        }

        return h;
    }
}

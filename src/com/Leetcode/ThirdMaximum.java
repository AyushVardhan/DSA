package com.Leetcode;

public class ThirdMaximum {
    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{1,2,-2147483648}));
    }

    private static int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;

        for (long num : nums) {
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num > second && num != first) {
                third = second;
                second = num;
            } else if (num > third && num != second && num != first) {
                third = num;
            }
        }

        return (int) (third == Long.MIN_VALUE ? first : third);
    }
}


/*  One Approach

    private static int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int data : nums)
            set.add(data);

        int[] arr = new int[set.size()];
        int k = 0;
        for (Integer data : set){
            arr[k++] = data;
        }

        if (arr.length <= 3){
            if (arr.length == 1)
                return arr[0];

            if (arr.length == 2)
                return Math.max(arr[0], arr[1]);

            if (arr.length == 3)
                return Math.min(arr[0], Math. min(arr[1],arr[2]));
        }

        int firstMax = Integer.MIN_VALUE, secondMax = 0;
        for (int i = 0; i < arr.length; i++){
            if (firstMax < arr[i]){
                secondMax = firstMax;
                firstMax = arr[i];
            }
        }

        firstMax = secondMax; secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < firstMax && arr[i] > secondMax){
                secondMax = arr[i];
            }
        }

        return secondMax;
    }

 */

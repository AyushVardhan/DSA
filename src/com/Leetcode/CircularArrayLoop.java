package com.Leetcode;

public class CircularArrayLoop {
    public static void main(String[] args) {
        System.out.println(circularArrayLoop(new int[]{-1, 2}));
    }

    private static boolean circularArrayLoop(int[] nums) { // Beats 100 %
        int[] loop = new int[nums.length];
        int loopIndex = 1;
        for (int i = 0; i < nums.length; i++) {
            int cur = i;
            if (loop[cur] == 0) {
                loop[cur] = loopIndex;
                while (true) {
                    int next = findNext(nums, cur);
                    if (cur == next || nums[next] * nums[cur] < 0) {
                        break;
                    }
                    if (loop[next] == loopIndex) {
                        return true;
                    }
                    loop[next] = loopIndex;
                    cur = next;
                }
                loopIndex++;
            }
        }
        return false;
    }

    private static int findNext(int[] nums, int cur) {
        int next = cur + nums[cur];
        while (next < 0) {
            next += nums.length;
        }
        return next % nums.length;
    }
}

/*  PROBLEM EXPLAINED

You are given a circular array nums of positive and negative integers. If a number k at an index is positive, then move forward k steps. Conversely, if it's negative (-k), move backward k steps. Since the array is circular, you may assume that the last element's next element is the first element, and the first element's previous element is the last element.

Determine if there is a loop (or a cycle) in nums. A cycle must start and end at the same index and the cycle's length > 1. Furthermore, movements in a cycle must all follow a single direction. In other words, a cycle must not consist of both forward and backward movements.



Example 1:

Input: [2,-1,1,2,2]
Output: true
Explanation: There is a cycle, from index 0 -> 2 -> 3 -> 0. The cycle's length is 3.
Example 2:

Input: [-1,2]
Output: false
Explanation: The movement from index 1 -> 1 -> 1 ... is not a cycle, because the cycle's length is 1. By definition the cycle's length must be greater than 1.
Example 3:

Input: [-2,1,-1,-2,-2]
Output: false
Explanation: The movement from index 1 -> 2 -> 1 -> ... is not a cycle, because movement from index 1 -> 2 is a forward movement, but movement from index 2 -> 1 is a backward movement. All movements in a cycle must follow a single direction.


Note:

-1000 ≤ nums[i] ≤ 1000
nums[i] ≠ 0
1 ≤ nums.length ≤ 5000


Follow up:

Could you solve it in O(n) time complexity and O(1) extra space complexity?

 */

/*  APPROACH 1

    private static boolean circularArrayLoop(int[] nums) {  // Much faster approach than in mentioned below approach
        int n = nums.length;
        if (n <= 1)
            return false;

        Set<Integer> set = new HashSet<>();  // keep a set to record all the iterated indices before the current cycle finding
        int i = 0;

        while (i < n) {

            if (!set.contains(i)) {  // any indices in the set means we have iterated on them and they will not form a cycle
                int j = i;

                Set<Integer> currCycle = new HashSet<>();  // same as solution 1, we have a set, currCycle to record the current iterated indices
                currCycle.add(j);

                while (nums[j] * nums[next(j, nums)] > 0 && j != next(j, nums) && !set.contains(j)) {  //  j must not occur during the previous cycle finding

                    j = next(j, nums);
                    if (currCycle.contains(j)) {   // the problems lies here
                        return true;
                    }
                    currCycle.add(j);
                }
                set.addAll(currCycle);   // when the current cycle finding fails, add all the interated indices into set
                i++;
            } else {
                i++;
            }
        }
        return false;
    }

    private static int next(int j, int[] nums) {
        if (j + nums[j] >= 0)
            return (j + nums[j]) % nums.length;
        return nums.length + (j + nums[j]) % nums.length;
    }

 */


/* APPROACH 2

    public static void main(String[] args) {
        System.out.println(circularArrayLoop(new int[]{-1,2}));
    }

    private static boolean circularArrayLoop(int[] nums) {
        if (nums.length <= 1)
            return false;

        Set<Integer> set = new HashSet<>();

        int i = 0, n = nums.length;

        while (i < n) {
            set.clear();
            set.add(i);
            int j = i;
            while (nums[j] * nums[next(j, nums)] > 0 && j != next(j, nums)) {
                j = next(j, nums);
                if (set.contains(j))
                    return true;

                set.add(j);
            }
            i++;
        }

        return false;
    }

    private static int next(int j, int[] nums) {
        if (j + nums[j] >= 0)
            return (j + nums[j]) % nums.length;
        return nums.length + (j + nums[j]) % nums.length;
    }

 */
package dk.learning;

import java.util.Arrays;

/**
 * Fixed Size Sliding Window
 * <p>
 * Given an array of integers nums consisting of only non-negative values, find the maximum sum among all
 * contiguous subarrays of size k.</p>
 * <p>
 * The goal is to efficiently compute the maximum sum without recalculating overlapping subarrays from scratch.</p>
 * <p>
 * <b>Example:</b>
 * </p>
 *
 * <pre>
 * Input: nums = [1, 2, 3, 7, 4, 1], k = 3
 * Output: 14
 *
 * Explanation:
 * The subarrays of size 3 are:
 * [1, 2, 3] → sum = 6
 * [2, 3, 7] → sum = 12
 * [3, 7, 4] → sum = 14
 * [7, 4, 1] → sum = 12
 *
 * The maximum sum is 14.
 * </pre>
 *
 * @author David Kariuki
 */
public class MaxSumSubarrayOfSizeK {

    public static void main(String[] args) {

        int[] array = new int[]{1, 2, 3, 7, 4, 1};
        int k = 3;

        System.out.println("Maximum sum in array " + Arrays.toString(array) + " is " + maxSumSubarrayOfSizeK(array, k)); // 6
    }


    private static int maxSumSubarrayOfSizeK(int[] nums, int k) {
        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        int largestSum = windowSum;

        for (int right = k; right < nums.length; right++) {
            int left = right - k;
            windowSum -= nums[left];
            windowSum += nums[right];
            largestSum = Math.max(largestSum, windowSum);
        }

        return largestSum;
    }
}

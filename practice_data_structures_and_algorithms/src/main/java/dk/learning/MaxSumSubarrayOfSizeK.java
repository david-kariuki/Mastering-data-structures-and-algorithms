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

    /**
     * Finding the maximum sum of a contiguous subarray of size k.
     * <p>
     * To solve this problem, we can use the sliding window technique. We will maintain a window of size k and
     * calculate the sum of the elements in that window.
     * <p>
     * As we slide the window to the right, we will subtract the element that is leaving the window and add the new
     * element that is entering the window. This way, we can efficiently compute the sum for each subarray of size
     * k without recalculating from scratch.
     *
     * @param nums Array
     * @param k    Size of the subarray
     * @return Maximum sum of a contiguous subarray of size k
     * Time Complexity: O(n) where n is the length of the input array. We traverse the array once to calculate the
     * initial sum and then once more to slide the window across the array.
     * Space Complexity: O(1) since we are using only a constant amount of extra space to store the current window
     * sum and the largest sum.
     */
    private static int maxSumSubarrayOfSizeK(int[] nums, int k) {
        int windowSum = 0;

        // Calculate the sum of the first window of size k
        for (int i = 0; i < k; i++) {                       //  ---------------- O(k)
            windowSum += nums[i];                           // ---------------- O(1)
        }

        int largestSum = windowSum;                         // ---------------- O(1)

        for (int right = k; right < nums.length; right++) { // ---------------- O(n - k)
            int left = right - k;                           // ---------------- O(1)
            windowSum -= nums[left];                        // ---------------- O(1)
            windowSum += nums[right];                       // ---------------- O(1)
            largestSum = Math.max(largestSum, windowSum);   // ---------------- O(1)
        }
        return largestSum;                                  // ---------------- O(1)
    }
}

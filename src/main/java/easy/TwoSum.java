package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return the indices of the two numbers such that
 * they add up to the target.
 *
 * <p>You may assume that each input has exactly one solution, and you may not use the same
 * element twice.</p>
 *
 * <p><b>Example:</b></p>
 * <pre>
 * Input: nums = [2, 7, 11, 15], target = 9
 * Output: [0, 1]
 * Explanation: nums[0] + nums[1] = 2 + 7 = 9
 * </pre>
 *
 * @author David Kariuki
 */
public class TwoSum {

    /*
     * Identify Patters
     * Brute Force
     * Two Pointers
     * Hash Map
     * Binary Search
     *
     * Hashmap allows us to store visited numbers and quickly check for the complement in O(1) time, leading to
     * an overall O(N) solution
     *
     */


    public static void main(String[] args) {

        int[] nums1 = new int[]{2, 7, 11, 15};  // 9
        int target1 = 9;

        System.out.print("Array : " + Arrays.toString(nums1) + " , Target -> " + target1);
        System.out.println("\n Result -> " + Arrays.toString(twoSum(nums1, target1)));
        System.out.println();

        int[] nums2 = new int[]{3, 2, 4};  // 6
        int target2 = 6;
        System.out.print("Array : " + Arrays.toString(nums1) + " , Target -> " + target1);
        System.out.println("\n Result -> " + Arrays.toString(twoSum(nums1, target1)));
        System.out.println();

    }

    /**
     * Finding the two numbers that add up to a target in an array can be efficiently solved using a hash map.
     * The idea is to iterate through the array and for each number, calculate its complement (the number needed to
     * reach the target). We then check if this complement exists in the hash map.
     * If it does, we have found our two numbers and can return their indices. If not, we add the current number
     * and its index to the hash map for future reference. This approach allows us to find the solution in O(N)
     * time complexity, where N is the length of the array.
     *
     * @param array  Array
     * @param target Target
     * @return Indices of the two numbers that add up to the target
     * Time complexity: O(n) - We traverse the array once, and each lookup in the hash map is O(1).
     * Space complexity: O(n) - In the worst case, we could store all N numbers in the hash map if no two numbers add up to the target.
     */
    public static int[] twoSum(int[] array, int target) {

        Map<Integer, Integer> numToIndex = new HashMap<>();         // ------------- O(1)

        for (int i = 0; i < array.length; i++) {                    // ---------------- O(n)
            int num = array[i];                                     // ---------------- O(1)
            int complement = target - num;                          // ---------------- O(1)

            if (numToIndex.containsKey(complement)) {               // ---------------- O(1)
                return new int[]{numToIndex.get(complement), i};    // ---------------- O(1)
            }

            numToIndex.put(num, i);                                 // ---------------- O(1)
        }
        return new int[]{};                                         // ---------------- O(1)
    }
}






















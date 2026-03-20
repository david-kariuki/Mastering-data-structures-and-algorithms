package dk.learning.arrays.maang_coding_exercises;

import java.util.Arrays;

/**
 * Given an array, write a function to get first, second best scores from the array and return it in new array.
 * <p>
 * Array may contain duplicates.
 * <p>
 * Example
 * myArray = {84,85,86,87,85,90,85,83,23,45,84,1,2,0}
 * firstSecond(myArray) // {90, 87}
 * </p>
 */
public class FirstSecondBestScores1DArray {

    public static void main(String[] args) {


        int[] myArray = {84, 85, 86, 87, 85, 90, 85, 83, 23, 45, 84, 1, 2, 0};
        System.out.print(Arrays.toString(findTopTwoScores(myArray)));
    }

    /**
     * Find first and second best scores from the array and return it in new array.
     *
     * @param array Input array
     * @return Array
     * Time complexity: O(n) - We traverse the array once to find the first and second highest scores.
     * Space complexity: O(1) - We are using a constant amount of space to store the first and second highest scores, regardless of the size of the input array.
     */
    public static int[] findTopTwoScores(int[] array) {

        int firstHighest = Integer.MIN_VALUE; // ------------- O(1)
        int secondHighest = Integer.MIN_VALUE; // ------------- O(1)

        for (int score : array) { // ------------- O(n)

            if (score > firstHighest) { // ------------- O(1)
                secondHighest = firstHighest; // ------------- O(1)
                firstHighest = score; // ------------- O(1)
            } else if (score > secondHighest && score < firstHighest) { // ------------- O(1)
                secondHighest = score; // ------------- O(1)
            }
        }

        return new int[]{firstHighest, secondHighest}; // ------------- O(1)
    }

    /**
     * Find first and second best scores from the array and return it in new array.
     *
     * @param array Input array
     * @return array
     * Time complexity: O(n) - We traverse the array twice, once to find the first highest score and once to find the second highest score.
     * Space complexity: O(1) - We are using a constant amount of space to store the first and second highest scores, regardless of the size of the input array.
     */
    public static int[] findTopTwoScoresLessOptimal(int[] array) {

        if (array.length <= 2) { // ------------- O(1)
            return array; // ------------- O(1)
        }

        int firstHighest = Integer.MIN_VALUE; // ------------- O(1)
        int secondHighest = Integer.MIN_VALUE; // ------------- O(1)

        for (int value : array) { // ------------- O(n)

            if (value >= firstHighest) { // ------------- O(1)
                firstHighest = value; // ------------- O(1)
            }
        }

        for (int value : array) { // ------------- O(n)
            if (value >= secondHighest && value < firstHighest) { // ------------- O(1)
                secondHighest = value; // ------------- O(1)
            }
        }

        return new int[]{firstHighest, secondHighest}; // ------------- O(1)
    }
}

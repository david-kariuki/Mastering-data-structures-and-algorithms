package dk.learning.maang_coding_exercises;

import java.util.Arrays;

/**
 * Write a function called middle that takes an array and returns a new array that contains all but the first
 * and last elements.
 * <code>
 * </>myArray = [1, 2, 3, 4]
 * middle(myArray)  # [2,3]
 * </p>
 */
public class MiddleFunction {

    public static void main(String[] args) {

        int[] array = new int[5];
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        array[3] = 4;
        array[4] = 5;

        System.out.println("\nArray before middle operation is : " + Arrays.toString(array));
        System.out.println("\nMiddle array is : " + Arrays.toString(middleArray(array)));
    }

    public static int[] middleArray(int[] array) {

        // If the input array has fewer than 3 elements, this will break logically. Safer version:
        if (array.length <= 2) {
            return new int[0]; // Return an empty array if there are not enough elements to form a middle array
        }

        int newArraySize = array.length - 2;
        int[] newArray = new int[newArraySize];

        for (int i = 0; i < newArraySize; i++) {
            newArray[i] = array[i + 1];
        }

        return newArray;
    }
}

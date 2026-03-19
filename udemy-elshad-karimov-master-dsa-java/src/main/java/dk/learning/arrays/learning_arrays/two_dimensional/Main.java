package dk.learning.arrays.learning_arrays.two_dimensional;

import java.util.Arrays;

/**
 * Main cass to test TwoDimensionalArray class.
 */
public class Main {

    public static void main(String[] args) {


        // Step 1: Declare
        int[][] int2DArray;  // ------------------ O(1)

        // Step 2: Instantiate In Memory
        int2DArray = new int[2][2]; // ------------------ O(1)

        // Initialize - Values
        int2DArray[0][0] = 1;   // ------------------ O(1)
        int2DArray[0][1] = 2;   // ------------------ O(1)
        int2DArray[1][0] = 3;   // ------------------ O(1)
        int2DArray[1][1] = 4;   // ------------------ O(1)

        // Combined complexity for additions above is O(mn) where m is number rows and n is number of columns

        // Print int array
        System.out.println(Arrays.deepToString(int2DArray));    // ------------------ O(1)

        // All together
        String s2DArray[][] = {{"a", "b"}, {"c", "d"}};         // ------------------ O(1)

        // Print string array
        System.out.println(Arrays.deepToString(s2DArray));      // ------------------ O(1)


        // Insert value to array
        System.out.println("\n\nInserting into the array:");
        TwoDimensionalArray tda = new TwoDimensionalArray(3, 3);
        tda.insertValueInTheArray(0, 0, 5);
        tda.insertValueInTheArray(0, 0, 6);
        tda.insertValueInTheArray(0, 1, 10);
        tda.insertValueInTheArray(1, 0, 20);
        tda.insertValueInTheArray(1, 1, 25);
        System.out.println("Inserted array : " + Arrays.deepToString(tda.arr));

        // Access cell
        System.out.println("\n\nAccessing cell!");
        tda.accessCell(0, 0);
        tda.accessCell(0, 2);

        // Traverse array
        System.out.println("Traversing array");
        tda.traverse2DArray();

        // Initializing all cells of array
        System.out.println("Initializing all cells of array");
        tda.insertValueInTheArray(0, 0, 35);
        tda.insertValueInTheArray(0, 1, 45);
        tda.insertValueInTheArray(1, 0, 55);
        tda.insertValueInTheArray(1, 1, 65);
        tda.insertValueInTheArray(0, 2, 75);
        tda.insertValueInTheArray(1, 2, 85);
        tda.insertValueInTheArray(2, 0, 95);
        tda.insertValueInTheArray(2, 0, 105);
        tda.insertValueInTheArray(2, 1, 115);
        tda.insertValueInTheArray(2, 2, 125);

        // Traverse array
        System.out.println("Traversing array");
        tda.traverse2DArray();

        // Linear search array
        System.out.println("\n\nSearching for value in the array");
        tda.searchElementInArray(125);
        tda.searchElementInArray(15);

        // Delete value in array
        System.out.println("\n\nDeleting an element in the array");
        tda.deleteElementInArray(2, 1);
    }
}

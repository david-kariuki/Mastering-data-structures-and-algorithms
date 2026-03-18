package dk.learning.arrays.single_dimensional;

/**
 * Main cass to test TwoDimensionalArray class.
 */
public class Main {

    public static void main(String[] args) {
        SingleDimensionalArray sda = new SingleDimensionalArray(10);
        sda.insert(0, 0);
        sda.insert(1, 10);
        sda.insert(2, 20);
        sda.insert(1, 30);
        sda.insert(12, 120);

        // Accessing Array Elements
        System.out.println("\n\nAccessing array elements!");
        var firstElement = sda.arr[0];
        var thirdElement = sda.arr[2];
        System.out.println(firstElement);
        System.out.println(thirdElement);

        // Array Traversal
        System.out.println("\n\nArray traversal!");
        sda.traverseArray();

        // Search element in array
        System.out.println("\n\nSearch elememnt!");
        sda.searchInArray(10);
        sda.searchInArray(20);
    }


}

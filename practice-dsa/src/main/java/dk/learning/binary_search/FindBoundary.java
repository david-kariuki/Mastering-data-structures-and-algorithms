package dk.learning.binary_search;

/**
 * Find Boundary (First True in Boolean Array)
 *
 * <p>Given a boolean array where all {@code false} values appear before {@code true} values,
 * find the index of the first {@code true} element.</p>
 *
 * <p>The array is guaranteed to follow a monotonic pattern:</p>
 *
 * <pre>
 * false, false, false, true, true, true
 * </pre>
 *
 * <p>If no {@code true} value exists, return {@code -1}.</p>
 *
 * <p><b>Examples:</b></p>
 *
 * <pre>
 * Input:  [false, false, true, true, true]
 * Output: 2
 *
 * Input:  [false, false, false]
 * Output: -1
 *
 * Input:  [true, true, true]
 * Output: 0
 * </pre>
 *
 * <p>This problem is a classic example of binary search on a monotonic condition,
 * where we are searching for the boundary point where values change from
 * {@code false} to {@code true}.</p>
 *
 * @author David Kariuki
 */
public class FindBoundary {

    public static void main(String[] args) {

        boolean[] arr = {false, false, false, true, true, true};
        System.out.println(findBoundary(arr)); // 3
    }

    /**
     * Find the index of the first true value in a sorted boolean array.
     *
     * @param array Array
     * @return Index of the first true value, or -1 if no true value is found.
     */
    public static int findBoundary(boolean[] array) {

        int left = 0;                   // Start of the array
        int right = array.length - 1;   // End of the array
        int boundaryIndex = -1;         // Initialize boundary index to -1 (not found)

        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate the middle index

            if (array[mid]) {           // If the middle element is true, we found a true value
                boundaryIndex = mid;    // Update the boundary index to the current middle index
                right = mid - 1;        // Continue searching in the left half to find the first true value
            } else {
                left = mid + 1;         // If the middle element is false, continue searching in the right half
            }
        }
        return boundaryIndex;           // Return the index of the first true value, or -1 if no true value is found
    }
}

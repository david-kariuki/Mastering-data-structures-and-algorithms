package dk.learning;

/**
 * Valid Palindrome
 *
 * <p>Given a string {@code s}, determine whether it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.</p>
 *
 * <p>A palindrome is a sequence that reads the same forward and backward after
 * removing non-alphanumeric characters and normalizing case.</p>
 *
 * <p><b>Examples:</b></p>
 *
 * <pre>
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: After removing non-alphanumeric characters and ignoring case,
 *              the string becomes "amanaplanacanalpanama", which is a palindrome.
 *
 * Input: s = "race a car"
 * Output: false
 * Explanation: After removing non-alphanumeric characters and ignoring case,
 *              the string becomes "raceacar", which is not a palindrome.
 * </pre>
 *
 * @author David Kariuki
 */
public class ValidPalindrome {

    public static void main(String[] args) {

        String string = "A man, a plan, a canal: Panama"; // Output: true
        System.out.println("String : " + string);
        System.out.print("\nIs Valid Palindrome : " + isPalindrome(string));
        System.out.println();
    }

    /**
     * To determine if a string is a palindrome while ignoring non-alphanumeric characters and case, we can use a
     * two-pointer approach.
     * We initialize two pointers, one at the beginning of the string and one at the end. We then move these pointers
     * towards each other, skipping any non-alphanumeric characters. At each step, we compare the characters at the
     * two pointers (after converting them to lower case). If they are not equal, we can conclude that the string is
     * not a palindrome.
     * If we successfully compare all characters without finding a mismatch, then the string is a palindrome.
     *
     * @param string String
     * @return Boolean
     */
    public static Boolean isPalindrome(String string) {

        int left = 0;                       // ------------ O(1)
        int right = string.length() - 1;    // ----------- O(1)

        while (left < right) {              // ------------- O(N)

            while (left < right && !Character.isAlphabetic(string.charAt(left))) { // O(N)
                left++; // Move left pointer to the right until it points to an alphanumeric character
            }

            while (left < right && !Character.isAlphabetic(string.charAt(right))) { // O(N)
                right--; // Move right pointer to the left until it points to an alphanumeric character
            }

            // Compare the characters at the left and right pointers, ignoring case
            if (Character.toLowerCase(string.charAt(left)) != Character.toLowerCase(string.charAt(right))) {
                return false; // If the characters do not match, the string is not a palindrome
            }

            left++;
            right--;
        }
        return true;

    }
}

package dk.learning;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest Substring Without Repeating Characters
 *
 * <p>Find the length of the longest substring in a given string without repeating characters.</p>
 *
 * <p><b>Examples:</b></p>
 *
 * <pre>
 * Input: "abccabcabcc"
 * Output: 3
 * Explanation: The longest substrings are "abc" and "cab", both of length 3.
 *
 * Input: "aaaabaaa"
 * Output: 2
 * Explanation: "ab" is the longest substring, with a length of 2.
 * </pre>
 *
 * @author David Kariuki
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s1 = "abccabcabcc";
        String s2 = "aaaabaaa";

        System.out.println(longestSubstringWithoutRepeatingChars(s1)); // 3
        System.out.println(longestSubstringWithoutRepeatingChars(s2)); // 2
    }

    /**
     * Find the length of the longest substring in a given string without repeating characters.
     *
     * @param string String
     * @return Length of the longest substring without repeating characters.
     */
    public static int longestSubstringWithoutRepeatingChars(String string) {

        int longest = 0;                                            // ---------------- O(1)
        int left = 0;                                               // ---------------- O(1)

        // Character -> count
        Map<Character, Integer> counter = new HashMap<>();          // ---------------- O(1) for initialization, O(n) in the worst case if all characters are unique

        for (int right = 0; right < string.length(); right++) {     // ---------------- O(n) where n is the length of the string
            char currentChar = string.charAt(right);                // ---------------- O(1)
            counter.put(
                    currentChar, counter.getOrDefault(currentChar, 0) + 1); // ---------------- O(1) for getOrDefault and put operations

            // If the current character is repeated, move the left pointer until there are no more duplicates
            while (counter.get(currentChar) > 1) {                  // ---------------- O(1) for get operation
                // Character at the left pointer
                char leftChar = string.charAt(left);                // ---------------- O(1)
                // Decrease the count of the left character
                counter.put(leftChar, counter.get(leftChar) - 1);   // ---------------- O(1) for get and put operations
                left++;                                             // ---------------- O(1)
            }

            // Update the longest length if the current window is larger
            longest = Math.max(longest, right - left + 1);          // ---------------- O(1)
        }
        return longest;                                             // ---------------- O(1)
    }
}

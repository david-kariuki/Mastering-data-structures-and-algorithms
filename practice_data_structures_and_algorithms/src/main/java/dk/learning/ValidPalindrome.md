# Valid Palindrome

## Problem

Given a string `s`, determine whether it is a palindrome, considering only alphanumeric characters and ignoring case.

A palindrome reads the same forward and backward after:

- removing non-alphanumeric characters
- converting letters to the same case

---

## Examples

```java
s ="A man, a plan, a canal: Panama"
```

Output:

```text
true
```

Explanation:

```text
After removing non-alphanumeric characters and ignoring case,
the string becomes "amanaplanacanalpanama"
```

---

```java
s ="race a car"
```

Output:

```text
false
```

Explanation:

```text
After removing non-alphanumeric characters and ignoring case,
the string becomes "raceacar"
```

---

## Pattern Thinking

This is a classic:

```text
Two Pointers
```

Why?

Because we want to compare characters from both ends of the string and move inward.

---

## Important Correction

Your current code uses:

```java
Character.isAlphabetic(...)
```

But the question says:

```text
considering only alphanumeric characters
```

That means you should use:

```java
Character.isLetterOrDigit(...)
```

`isAlphabetic` only checks letters, so it would wrongly skip digits.

For example:

```text
"1a1"
```

should be a valid palindrome, but `isAlphabetic` would ignore the `1`s.

---

## Correct Code

```java
public static Boolean isPalindrome(String string) {

    int left = 0;
    int right = string.length() - 1;

    while (left < right) {

        while (left < right && !Character.isLetterOrDigit(string.charAt(left))) {
            left++;
        }

        while (left < right && !Character.isLetterOrDigit(string.charAt(right))) {
            right--;
        }

        if (Character.toLowerCase(string.charAt(left)) != Character.toLowerCase(string.charAt(right))) {
            return false;
        }

        left++;
        right--;
    }

    return true;
}
```

---

## Core Idea

We use two pointers:

- `left` starts at the beginning
- `right` starts at the end

Then we:

1. skip non-alphanumeric characters
2. compare valid characters ignoring case
3. move both pointers inward
4. stop if a mismatch is found

If no mismatch is found, the string is a palindrome.

---

## Step-by-Step Walkthrough

### Example

```java
string ="A man, a plan, a canal: Panama"
```

---

## Step 1: Initialize Pointers

```java
int left = 0;
int right = string.length() - 1;
```

So:

- `left` starts at `'A'`
- `right` starts at `'a'`

---

## Step 2: Skip Non-Alphanumeric Characters

### Left side

```java
while(left<right &&!Character.

isLetterOrDigit(string.charAt(left))){
left++;
        }
```

Move `left` forward until it points to a valid character.

### Right side

```java
while(left<right &&!Character.

isLetterOrDigit(string.charAt(right))){
right--;
        }
```

Move `right` backward until it points to a valid character.

This means spaces, commas, and colons are ignored.

---

## Step 3: Compare Characters

```java
if(Character.toLowerCase(string.charAt(left))!=Character.

toLowerCase(string.charAt(right))){
        return false;
        }
```

We convert both characters to lowercase before comparing so that:

```text
'A' == 'a'
```

---

## Step 4: Move Inward

```java
left++;
right--;
```

After a successful match:

- move `left` one step right
- move `right` one step left

Then repeat.

---

## Walkthrough with Main Example

```text
"A man, a plan, a canal: Panama"
```

Valid characters compared:

```text
A == a
m == m
a == a
n == n
a == a
p == P
l == l
a == a
n == n
a == a
c == c
a == a
n == n
a == a
l == l
P == p
a == a
n == n
a == a
m == m
a == A
```

All match, so return:

```text
true
```

---

## Walkthrough with Failing Example

```text
"race a car"
```

After ignoring spaces:

```text
raceacar
```

Compare from both ends:

```text
r == r
a == a
c != e
```

Mismatch found, so return:

```text
false
```

---

## Why This Works

A palindrome must match from both ends toward the center.

The two-pointer approach is perfect because:

- left checks from the start
- right checks from the end
- both move inward together

Ignoring non-alphanumeric characters during traversal avoids building a cleaned string first.

---

## Time Complexity

O(n)

Why?

- each character is visited at most once by either pointer
- even though there are nested `while` loops, the pointers only move forward or backward across the string once

---

## Space Complexity

O(1)

Why?

- no extra string, array, or list is created
- only a few variables are used:
    - `left`
    - `right`

---

## Alternative Approach

Another way is:

1. build a cleaned lowercase string containing only alphanumeric characters
2. check if that cleaned string is a palindrome

That works, but it uses extra space.

---

## Why Two Pointers is Better

- no extra string building
- space efficient
- standard interview pattern

---

## Interview Thinking

When you see:

- palindrome
- compare from both ends
- ignore some characters

Think:

```text
Two Pointers
```

Ask yourself:

- can I compare from both ends?
- can I skip invalid characters while traversing?
- do I need to normalize case before comparing?

---

## Core Pattern

1. Start one pointer at the left
2. Start one pointer at the right
3. Skip invalid characters
4. Compare normalized values
5. Move inward

---

## Final Takeaway

- This is a two-pointer problem
- The key is to skip non-alphanumeric characters while comparing from both ends
- Use `Character.isLetterOrDigit`, not `Character.isAlphabetic`
- If all valid characters match, the string is a palindrome
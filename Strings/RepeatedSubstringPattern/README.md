# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
The problem requires checking if a given string can be constructed by repeating a substring multiple times. Initially, it seems logical to try and extract substrings of different lengths and see if repeating them forms the original string.

# Approach
<!-- Describe your approach to solving the problem. -->
1. **Determine Possible Substring Lengths:** Iterate from half the length of the string down to 1. The length of the substring must be a divisor of the string's length for it to repeat to form the entire string.
2. **Check Substring Repetition:** 
*   For each possible substring length:
    + Skip if the length isn't a divisor of the total length.
    + Extract the substring of the current length.
    + Repeat this substring enough times to match the original string length.
    + Check if the repeated substring matches the original string.

3. **Return Result:** If any repeated substring matches the original string, return true. If no such substring is found, return false.

# Complexity
#### Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
+ The outer loop runs approximately $2√n$ times, where $n$ is the length of the string.
+ Inside the loop, creating the substring and repeating it takes approximately $O(n)$ time.
+ Thus, the overall time complexity is $O(√n*n)$.

#### Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
+ The space complexity is dominated by the $StringBuilder$, which can store a copy of the string, leading to a space complexity of $O(n)$.

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

# Approach
<!-- Describe your approach to solving the problem. -->
<H4>I have done this problem with 3 different type of approachs</H4>

1) Recursion (Top to Bottom)
   - In the resursion, I have created the solve function which is find the nth fibonacci number recursively and return the final answer.

![Image1.jpg](https://assets.leetcode.com/users/images/89cd2440-11dc-4503-8d4c-97f7657fa1e6_1718619135.625784.jpeg)

2) Memoization (Bottom to Top)
   - In the memoization, I have made a dp array which stores the previous value which it use repeatedly, so that to decrease the time complexity we store those values in the array.

![Image2.jpg](https://assets.leetcode.com/users/images/1ace49ab-e33e-4b04-9539-cc4b7a5d5498_1718619155.7435164.jpeg)


3) With constant space (Bottom to Top)
   - In this approach, I created 3 variable a, b, c. Where c stores the finale value which is sum of a + b. I simply run a loop. In every iteration of loop all variable update their values, c = a + b, a = b, b = c. At the end I return the value of c.

![Image3.jpg](https://assets.leetcode.com/users/images/23a81bcb-a5fb-46c0-9b89-ceab1ef14b5c_1718619177.9920247.jpeg)



# Complexity

1) Recursion (Top to Bottom)
   - Run time complexity: $O(2^N)$
   - Space complexity: $O(N)$
2) Memoization (Bottom to Top)
   - Run time complexity: $O(N)$
   - Space complexity: $O(N)$
3) With constant space (Bottom to Top)
   - Run time complexity: $O(N)$
   - Space complexity: $O(1)$

![image.png](https://assets.leetcode.com/users/images/1f337fe6-bd35-4ce6-aa02-2f6843b96196_1718619295.8326309.png)

![image.png](https://assets.leetcode.com/users/images/8115c3b8-6755-439b-9e25-afbb3656c5f0_1718619391.096007.png)
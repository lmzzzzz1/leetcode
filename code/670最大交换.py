"""Given a non-negative integer,
 you could swap two digits at most once to get the maximum valued number.
 Return the maximum valued number you could get.

Example 1:
Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.
Example 2:
Input: 9973
Output: 9973
Explanation: No swap.
Note:
The given number is in the range [0, 108]"""

# 解法一：暴力遍历法


class Solution(object):
    def maximumSwap(self, num):
        """
        :type num: int
        :rtype: int
        """
        A = list(str(num))
        ans = A
        for i in range(len(A)):
            for j in range(i+1,len(A)):
                A[i],A[j] = A[j],A[i]
                if A > ans:ans = A
                A[i],A[j] = A[j],A[i] 
        return int(''.join(ans))       
if __name__ == "__main__":
    s1 = Solution()
    print(s1.maximumSwap(8921))
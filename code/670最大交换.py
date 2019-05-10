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


# class Solution(object):
#     def maximumSwap(self, num):
#         """
#         :type num: int
#         :rtype: int
#         """
#         A = list(str(num))
#         ans = A[:]
#         for i in range(len(A)):
#             for j in range(i+1,len(A)):
#                 A[i],A[j] = A[j],A[i]
#                 if A > ans:ans = A[:]
#                 A[i],A[j] = A[j],A[i] 
#         return int(''.join(ans)) 

# 解法二：使用last字典存储 1-9每一个数字最后出现的索引值，这样在遍历的过程中，只要从9到当前值中，有比当前值大的，
# 而且索引比当前值大（在当前值右边）就交换当前值和大的值，交换一次就返回
class Solution(object):
    def maximumSwap(self, num):
        """
        :type num: int
        :rtype: int
        """
        A = list(map(int,str(num))) # map(function,iterable) A是整型list
        last = {x:i for i,x in enumerate(A)} # {key---nums的不同值(1-9):values---1到9出现的最后一次的位置}
        for i,x in enumerate(A):
            for d in range(9,x,-1):
               if last.get(d)>i: # 如果从9到当前值遍历过程中出现了last里的key，而且该key的value索引大于i那么
                 A[i],A[last[d]] = A[last[d]],A[i]
                 return int("".join(map(str,A))) # 一次交换就返回
        return num    
                       



if __name__ == "__main__":
    s1 = Solution()
    print(s1.maximumSwap(8921))
'''Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]'''

class Solution(object):

#  解法一：暴力搜索,使用递归生成2的2n次方个序列，然后判断

    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        ans = []
        def isValid_by_official(s):
            """
            :type s: str
            :rtype: bool
            """
            word_dict = {")": "(", "}": "{", "]": "["}
            stack_list = []

            for char in s:
                if char in word_dict:
                    top_element = stack_list.pop() if stack_list else "$"
                    if top_element != word_dict[char]:
                        return False
                else: stack_list.append(char)
            return not stack_list

        def generate(A=''):
            if len(A)== 2*n:
                if isValid_by_official(A):
                    ans.append(A)
            else:
                A = A+'('
                generate(A)
                A = A[:-1]
                A = A+')'
                generate(A)
                A = A[:-1]
        generate()
        return ans
# 解法二： 回溯法
    def generateParenthesis_backtrack(self,n):
        """
        :type n: int
        :rtype: List[str]
        """
        ans = []
        def backtrack(A='',left=0,right=0):
            if len(A)==2*n:
                ans.append(A)
                return
            else: 
                if left<n:
                    backtrack(A+'(',left+1,right)
                if left>right:
                    backtrack(A+')',left,right+1)
        backtrack()
        return ans



if __name__ == "__main__":
    s= Solution()
    print(s.generateParenthesis_backtrack(3))
               
                
                
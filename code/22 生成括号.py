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
                else:
                    stack_list.append(char)
            return not stack_list

        def generate(A=''):
            if len(A) == 2*n:
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

    def generateParenthesis_backtrack(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        ans = []

        def backtrack(A='', left=0, right=0):
            if len(A) == 2*n:
                ans.append(A)
                return
            else:
                if left < n:
                    backtrack(A+'(', left+1, right)
                if left > right:
                    backtrack(A+')', left, right+1)
        backtrack()
        return ans
# 解法三： 动态规划

    def generateParenthesis_dynamic(self, n):
        '''
        什么是动态规划？在此题中，动态规划的思想类似于数学归纳法，当知道所有i<n的情况时，我们可以通过某种算法算出i=n的情况。 
        本题最核心的思想是，考虑i=n时相比n-1组括号增加的那一组括号的位置。

        具体思路如下： 当我们清楚所有i<n时括号的可能生成排列后，对与i=n的情况，我们考虑整个括号排列中最左边的括号。
        它一定是一个左括号，那么它可以和它对应的右括号组成一组完整的括号"( )"，我们认为这一组是相比n-1增加进来的括号。

        那么，剩下n-1组括号有可能在哪呢？ 【这里是重点，请着重理解】 剩下的括号要么在这一组新增的括号内部，要么在这一组新增括号的外部（右侧）。

        既然知道了i<n的情况，那我们就可以对所有情况进行遍历： "(" + 【i=p时所有括号的排列组合】 + ")" + 【i=q时所有括号的排列组合】 
        其中 p + q = n-1，且p q均为非负整数。 事实上，当上述p从0取到n-1，q从n-1取到0后，所有情况就遍历完了。
        '''
        if n == 0:
            return []
        total_l = []
        total_l.append([None])
        total_l.append(["()"])
        for i in range(2,n+1):  # 开始计算i时的括号组合，记为l
            l = []
            for j in range(i): #遍历所有可能的括号内外组合
                now_list1 = total_l[j]
                now_list2 = total_l[i-1-j]
                for k1 in now_list1:  #开始具体取内外组合的实例
                    for k2 in now_list2:
                        if k1 == None:
                            k1 = ""
                        if k2 == None:
                            k2 = ""
                        el = "(" + k1 + ")" + k2
                        l.append(el)
            total_l.append(l)
        return total_l[n]


if __name__ == "__main__":
    s = Solution()
    print(s.generateParenthesis_backtrack(3))

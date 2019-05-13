'''
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
'''
# 解法一：一看就不能用循环，因为你不知道有几个循环，所以用迭代
class Solution:
    def letterCombinations(self, digits: str) -> [str]:
        '''
        return List[str]
        '''
        if len(digits)==0:
            return []
        ans = []
        
        dic = {'2':['a','b','c'],
               '3':['d','e','f'],
               '4':['g','h','i'],
               '5':['j','k','l'],
               '6':['m','n','o'],
               '7':['p','q','r','s'],
               '8':['t','u','v'],
               '9':['w','x','y','z']}
        str_list = list(digits)
        def backtrack(combination,next_digits):
            '''
            :type combination:str
            :type next_digits:str
            '''
            # 如果没有下一个要检查的数字
            if len(next_digits)==0:
            # 把combination加上去
                ans.append(combination)  
            # 如果还有要检查的数字
            else:
                for letter in dic[next_digits[0]]:
                    backtrack(combination+letter,next_digits[1:])
        backtrack('',digits)
        return ans
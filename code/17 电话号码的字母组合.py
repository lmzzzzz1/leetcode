'''
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
'''
# 解法一：一看就不能用循环，因为你不知道有几个循环，所以用递归


class Solution:
    def letterCombinations(self, digits: str) -> [str]:
        '''
        return List[str]
        '''
        if len(digits) == 0:
            return []
        ans = []
# 写一个字典来保存数字与字母的对应关系
        dic = {'2': ['a', 'b', 'c'],
               '3': ['d', 'e', 'f'],
               '4': ['g', 'h', 'i'],
               '5': ['j', 'k', 'l'],
               '6': ['m', 'n', 'o'],
               '7': ['p', 'q', 'r', 's'],
               '8': ['t', 'u', 'v'],
               '9': ['w', 'x', 'y', 'z']}
        
        def backtrack(combination, next_digits):
            '''
            :type combination:str
            :type next_digits:str
            '''
            # 如果没有下一个要检查的数字
            if len(next_digits) == 0:
                # 把combination加上去
                ans.append(combination)
            # 如果还有要检查的数字
            else:
                for letter in dic[next_digits[0]]:
                    backtrack(combination+letter, next_digits[1:])
        backtrack('', digits)
        return ans

# 解法二： 迭代法
    def letterCombinations2(self, digits: str) -> [str]:
        dic = {
            "2":"abc",
            "3":"def",
            "4":"ghi",
            "5":"jkl",
            "6":"mno",
            "7":"pqrs",
            "8":"tuv",
            "9":"wxyz"
        }
        if not digits:
            return []
        res = ['']
        for number in digits:
            next_res = []
            for word in dic[number]:
                for tmp in res:
                    next_res.append(tmp+word)
            res = next_res
        return res        
if __name__ == "__main__":
    s = Solution()
    test = "23"
    print(s.letterCombinations2(test))
"""给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true

"""
class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        word_dict = {"(":")","{":"}","[":"]"}
        if not s: 
            return True
        elif len(s)%2 ==1:
            return False
        else:
            left = int(len(s)/2-1)
            right = int(len(s)/2) # 找中间那两个
            while(left>=0):
                if word_dict[s[left]] != s[right]:
                    return False
                left-=1
                right+=1
            return True






if __name__ == "__main__":
    test_string = "{[()]}"
    s = Solution()
    print(s.isValid(test_string))
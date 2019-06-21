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
#  解法一：利用栈的思想，先进后出


class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        n = len(s)
        if not s:
            return True
        elif n % 2 == 1:
            return False
        else:  # 如果是偶数
            word_dict = {")": "(", "}": "{", "]": "["}
            stack_list = ['#']
            for i in s:
                if i not in word_dict:
                    stack_list.append(i)
                else:
                    if word_dict[i] != stack_list[-1]:
                        return False
                    else:
                        stack_list.pop()
            if stack_list == ["#"]:
                return True
            else:
                return False

# 第二版，看过官方解法，写的太不简洁，重新写
    def isValid_by_official(self, s):
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


if __name__ == "__main__":
    test_string = "()[]{}"
    s = Solution()
    print(s.isValid_by_official(test_string))

"""罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。

字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。

示例 1:

输入: 3
输出: "III"
示例 2:

输入: 4
输出: "IV"
示例 3:

输入: 9
输出: "IX"
示例 4:

输入: 58
输出: "LVIII"
解释: L = 50, V = 5, III = 3.
示例 5:

输入: 1994
输出: "MCMXCIV"
解释: M = 1000, CM = 900, XC = 90, IV = 4."""

# 方法一，创建数字与罗马文字的对应集合,用current表示num减去n个千位，m个900，x个500.。。的结果，
# 迭代条件： 只要current-1000大于等于0，就继续减下去


# class Solution(object):
#     def intToRoman(self, num):
#         """
#         :type num: int
#         :rtype: str
#         """
#         roman_dim = [[1, 'I'], [4, 'IV'], [5, 'V'], [9, 'IX'],
#                      [10, 'X'], [40, 'XL'], [50, 'L'], [90, 'XC'],
#                      [100, 'C'], [400, 'CD'], [500, 'D'], [900, 'CM'], [1000, 'M']]
#         current = num
#         dim = 12
#         roman_str = ''
#         while current > 0:
#             while current//roman_dim[dim][0] == 0:  # '//'符号表示除法向下取整，比如 5//2 = 2
#                 dim -= 1
#             while current-roman_dim[dim][0] >= 0:
#                 current -= roman_dim[dim][0]
#                 roman_str += roman_dim[dim][1]
#         return roman_str

# 方法二，创建数字与罗马文字的对应集合,用一个循环，k表示num含有多少个1000，100，900，500.。。。


class Solution:

    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        values = [1000, 900, 500, 400,
                  100, 90, 50, 40,
                  10, 9, 5, 4, 1]
        symbols = ["M", "CM", "D", "CD",
                   "C", "XC", "L", "XL",
                   "X", "IX", "V", "IV",
                   "I"]
        roman_str = ''
        i = 0
        while(i<len(values)):
            k = int(num/values[i]) #k 表示有个千，百，十。。。
            for n in range(k):
                roman_str += symbols[i]
            num = num-k*values[i]
            i+=1
        return roman_str



if __name__ == "__main__":
    S = Solution()
    print(S.intToRoman(1994))
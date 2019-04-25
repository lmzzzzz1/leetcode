"""
例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
示例 5:

输入: "MCMXCIV"
输出: 1994
解释: M = 1000, CM = 900, XC = 90, IV = 4.
"""
# 方法一，参考12题的方法，构建一个索引变量current，表示现在算到第几位了

class Solution1:
    def romanToInt(self, s: str):
        values = [1000, 900, 500, 400,
                  100, 90, 50, 40,
                  10, 9, 5, 4, 1]
        symbols = ["M", "CM", "D", "CD",
                   "C", "XC", "L", "XL",
                   "X", "IX", "V", "IV",
                   "I"]
        num = 0
        current = 0
        while(current < len(values)):
            while s[:1] == symbols[current] or s[:2] == symbols[current]:
                num += values[current]
                s = s[len(symbols[current]):]
            current += 1
        return num

# 方法二，尝试 hashmap 的方法

class Solution2:
    def romanToInt(self, s: str):
        # values = [1000, 900, 500, 400,
        #           100, 90, 50, 40,
        #           10, 9, 5, 4, 1]
        symbols = {"M":1000, "CM":900, "D":500, "CD":400,
                   "C":100, "XC":90, "L":50, "XL":40,
                   "X":10, "IX":9, "V":5, "IV":4,
                   "I":1}
        num = 0
        while s:
            if s[:2] in symbols:
                num += symbols[s[:2]]
                s = s[2:]
            elif s[:1] in symbols:
                num += symbols[s[:1]]
                s = s[1:]
        return num

# 方法三，不用全部都放入字典

class Solution3:
    def romanToInt(self, s: str):

        symbols = {"M":1000, "D":500,
                   "C":100, "L":50,
                   "X":10, "V":5,
                   "I":1}
        num = symbols[s[-1]] # num初始化为最后的字符对应的值
        for i in range(len(s)-1):
            if symbols[s[i]] < symbols[s[i+1]]:
                num -= symbols[s[i]] 
            else :
                num += symbols[s[i]]
        return num


if __name__ == "__main__":
    s = Solution3()
    test_str = "MCMXCIV"
    print(s.romanToInt(test_str))
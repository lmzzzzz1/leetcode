'''
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.
'''
# 方法一：Python 特性，取每一个单词的同一位置的字母，看是否相同,利用python里面的set和zip函数转化为['fff','lll','ooi'......]       

class Solution:

    def longestCommonPrefix(self, strs) -> str:
        """
        :type strs: List[str]
        :rtype: str
        """
        prefix = ""
        for tmp in zip(*strs):
            tmp_set = set(tmp) # zip()是Python的一个内建函数，它接受一系列可迭代的对象作为参数，将对象中对应的元素打包成一个个tuple（元组）
            if len(tmp_set)==1:
                prefix+=tmp[0]
            else: break
        return prefix        

#  方法二：取一个单词 s，和后面单词比较，看 s 与每个单词相同的最长前缀是多少！遍历所有单词
    def longestCommonPrefix2(self, strs) -> str:
        if not strs: return ''
        prefix = strs[0]
        i = 1
        while i<len(strs):
            while strs[i].find(prefix)!=0:
                prefix = prefix[:-1]
            i+=1
        return prefix
#  方法三：按字典排序数组，比较第一个，和最后一个单词，有多少前缀相同
    def longestCommonPrefix3(self, strs) -> str:
        if not strs: return ''
        prefix = ''
        n = len(strs)
        strs.sort()
        l1,l2 = strs[0],strs[n-1]
        for i in range(len(l1)):
            if l1[i]==l2[i] and i<len(l2):
                prefix+=l1[i]
            else: break
        return prefix

    
if __name__ == "__main__":
    s = Solution()
    # strs = ["a"]
    # print(s.longestCommonPrefix(strs))
    test = ["flower","flow","flight"]
    print(s.longestCommonPrefix3(test))
    # print(test[:,[2]])
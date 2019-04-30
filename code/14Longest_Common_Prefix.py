class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        prefix = ''

        minlen = 1000
        for word in strs:
            minlen = min(minlen,len(word))
        for i in range(minlen):
            j = 0
            while(j<len(strs)-1 and strs[j][:i]==strs[j+1][:i]):
                j+=1
            if j==len(strs)-1 and i != 0:
                prefix = strs[0][:i]
            if j==len(strs)-1 and i ==0:
                prefix = strs[0][:i+1]    
        return prefix

if __name__ == "__main__":
    s = Solution()
    strs = ["a"]
    print(s.longestCommonPrefix(strs))

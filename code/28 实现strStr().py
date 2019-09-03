class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        n = len(needle)
        m = len(haystack)
        if n == 0:
            return 0
        else:
            for i in range(m):
                if i + n > m:
                    return -1
                else:
                    if haystack[i:] == needle or haystack[i:i + n] == needle:
                        return i
            return -1

if __name__ == '__main__':
    s = Solution()
    needle = "ll"
    haystack = "hello"
    print(s.strStr(haystack, needle))

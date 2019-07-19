class Solution(object):
    # 解法一：迭代法
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        n, m = len(nums1), len(nums2)
        if n > m:
            return self.findMedianSortedArrays(nums2, nums1)
        k = (m + n) // 2
        left = 0
        right = n
        while left <= right:
            cut1 = left + (right - left) // 2
            cut2 = k - cut1
            l1 = nums1[cut1 - 1] if cut1 != 0 else float('-inf')
            l2 = nums2[cut2 - 1] if cut2 != 0 else float('-inf')
            r1 = nums1[cut1] if cut1 != n else float('inf')
            r2 = nums2[cut2] if cut2 != m else float('inf')
            if l1 > r2:
                right = cut1 - 1
            elif l2 > r1:
                left = cut1 + 1
            else:
                if (n + m) % 2 == 0:
                    l = max(l1, l2)
                    r = min(r1, r2)
                    return (l + r) / 2
                else:
                    return float(min(r1, r2))



if __name__ == "__main__":
    s = Solution()
    A = [1, 2, 3]
    B = [4, 5, 6, 7]
    print(s.findMedianSortedArrays(A, B))

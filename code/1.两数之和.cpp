#include <vector>
/*
 * @lc app=leetcode.cn id=1 lang=cpp
 *
 * [1] 两数之和
 */

// @lc code=start
using namespace std;
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {

        for(int i = 0; i < nums.size() - 1; i++)
        {
            for(int j = i+1; j < nums.size(); j++)
            {
                if (nums[i] + nums[j] == target)
                {
                    vector<int> res = {i,j};
                    return res;
                }
            }
        }
        return vector<int> a;
    }
};
// @lc code=end


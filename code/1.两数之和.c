/*
 * @lc app=leetcode.cn id=1 lang=c
 *
 * [1] 两数之和
 */

// @lc code=start
#define NULL ((void *)0)

void swap(int *const a, int *const b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}

int partition(const int *const nums, int *const indexes, int lo, int hi)
{
    int i = lo, j = hi+1;
    int val = nums[indexes[lo]];
    while(1) {
        while(nums[indexes[++i]]<val && i!=hi);
        while(nums[indexes[--j]]>val && j!=lo);
        if(i>=j) break;
        swap(indexes+i, indexes+j);
    }
    swap(indexes+lo, indexes+j);
    return j;
}

void sort(int *const nums, int *const indexes, int lo, int hi)
{
    if (lo >= hi)
        return;
    int j = partition(nums, indexes, lo, hi);
    sort(nums, indexes, lo, j - 1);
    sort(nums, indexes, j + 1, hi);
}

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int *twoSum(int *nums, int numsSize, int target, int *returnSize)
{
    if (numsSize < 2)
        return NULL;
    int *res = malloc(2 * sizeof(int));
    int indexes[numsSize];
    for (int i = 0; i < numsSize; ++i)
    {
        indexes[i] = i;
    }
    sort(nums, indexes, 0, numsSize-1);
    int i = 0, j = numsSize -1 ;
    while (i<j)
    {
        if(nums[indexes[i]] + nums[indexes[j]] < target){
            ++i;
        }else if (nums[indexes[i]] + nums[indexes[j]] > target)
        {
            --j;
        }else{
            res[0] = indexes[i];
            res[1] = indexes[j];
            *returnSize = 2;
            return res;
        }
        
    }
    return NULL;
}
// @lc code=end
int main(){
    int nums[] = {2,5,5,11};
    int returnSize = 0;
    int * res = twoSum(nums,4,10,&returnSize);

}
class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length;
        int lastans = 0;
        int ele = -1;
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] > right) {
                ele = i;
                lastans = 0;
            }
            else if(nums[i] >= left && nums[i] <= right) {
                lastans = i - ele;
                count += lastans;
            }
            else {
                count += lastans;
            }
        }
        return count;
    }
}
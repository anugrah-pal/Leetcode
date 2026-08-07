class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length;
        int count = 0;
        int lastAns = 0;
        int ele = -1;
        for(int i = 0; i < n; i++) {
            if(nums[i] > right) {
                ele = i;
                lastAns = 0;
            }
            else if(left <= nums[i] && nums[i] <= right) {
                lastAns = i - ele;
                count += lastAns;
                
            }
            else if(nums[i] < left) {
                count += lastAns;
            }
        }
        return count;
    }
}